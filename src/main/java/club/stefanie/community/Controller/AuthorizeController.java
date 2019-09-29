package club.stefanie.community.controller;

import club.stefanie.community.dto.AccessTokenDTO;
import club.stefanie.community.dto.GithubUser;
import club.stefanie.community.model.User;
import club.stefanie.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String cilent_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String redirect_uri;
    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(cilent_id);
        accessTokenDTO.setClient_secret(client_secret);
        String access_token=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getUser(access_token);
        String name=githubUser.getName();
        if(name!=null){
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }
        else{
            return "redirect:/";

        }
    }
}
