using System.ComponentModel.DataAnnotations;

namespace orbita_server.Models.ViewModels
{
    //Login - UserName, Name - Name
    public class RegisterViewModel
    {
        [Required]
        public string NickName { get; set; }

        [Required]
        public string Login { get; set; }

        [Required]
        public string Password { get; set; }
    }
}
