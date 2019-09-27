using Microsoft.IdentityModel.Tokens;
using orbita_server.Models;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;

namespace orbita_server.Services
{
    public static class TokenService
    {
        public static async Task<string> GetToken(User user)
        {
            const int expireInForToken = 300000;

            var key = "U8_.wpvk93fPWG<f2$Op[vwegmQGF25_fNG2V0ijnm2e0igv24g";

            var securityKey = new SymmetricSecurityKey(Encoding.ASCII.GetBytes(key));
            var timeNow = DateTime.UtcNow;

            var token = new JwtSecurityToken(
                    issuer: "Orbita-server",
                    notBefore: timeNow,
                    expires: timeNow.Add(TimeSpan.FromMinutes(expireInForToken)),
                    claims: new[]
                    {
                        new Claim("_key", user.Key.ToString()),
                        new Claim("_login", user.UserName)
                    },
                    signingCredentials:
                        new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256));

            var accessToken = new JwtSecurityTokenHandler().WriteToken(token);

            return accessToken;
        }
    }
}
