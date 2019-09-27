using Microsoft.AspNetCore.Identity;
using orbita_server.Models.ViewModels;

namespace orbita_server.Models
{
    public class User : IdentityUser
    {
        public string Name { get; set; }

        public long Key { get; set; } = 1;

        public User()
        {

        }

        public static explicit operator User(RegisterViewModel model)
        {
            return new User()
            {
                UserName = model.Login,
                Name = model.NickName,
                Email = "ga@gmail.com"
            };
        }
    }
}