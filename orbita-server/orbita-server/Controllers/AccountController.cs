using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using orbita_server.Models;
using orbita_server.Models.ViewModels;
using System.Threading.Tasks;

namespace orbita_server.Controllers
{
    [Route("api/account")]
    [ApiController]
    public class AccountController : ControllerBase
    {
        private readonly UserManager<User> userManager;
        private readonly SignInManager<User> signInManager;

        public AccountController(UserManager<User> userManager, SignInManager<User> signInManager)
        {
            this.userManager = userManager;
            this.signInManager = signInManager;
        }

        [HttpPost, Route("register")]
        public async Task<IActionResult> Register(RegisterViewModel model)
        {
            if ((await userManager.FindByNameAsync(model.Login)) != null)
            {
                return BadRequest();
            }

            var user = (User)model;
            var result = await userManager.CreateAsync(user, model.Password);

            if (!result.Succeeded)
            {
                return BadRequest(result.Errors);
            }

            user.EmailConfirmed = true;
            await userManager.UpdateAsync(user);

            var token = await Services.TokenService.GetToken(user);
            return Ok(token);
        }

        [HttpPost, Route("login")]
        public async Task<IActionResult> Login(LoginViewModel model)
        {
            if ((await userManager.FindByNameAsync(model.Login)) == null)
            {
                return BadRequest();
            }

            var user = await userManager.FindByNameAsync(model.Login);

            var result = await signInManager.PasswordSignInAsync(
                user,
                model.Password,
                false,
                false);

            if (!result.Succeeded)
            {
                return BadRequest();
            }

            user.Key++;
            await userManager.UpdateAsync(user);

            var token = await Services.TokenService.GetToken(user);
            return Ok(token);
        }

        [HttpGet, Route("check")]
        public string Check()
        {
            return "!";
        }
    }
}