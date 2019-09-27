using System.ComponentModel.DataAnnotations;

namespace orbita_server.Models.ViewModels
{
    public class LoginViewModel
    {
        [Required]
        public string Login { get; set; }

        [Required]
        public string Password { get; set; }
    }
}
