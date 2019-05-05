package com.example.demo.controller.base;

import com.example.demo.dao.User;
import com.example.demo.service.base.UserServiceImpl;
import com.example.demo.util.RequestDto;
import com.example.demo.util.ResultDto;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Api(tags = "登陆")
@RestController
public class WebController {

    //private static final Logger LOGGER = (Logger) LogManager.getLogger(WebController.class);

   @Autowired
   private UserServiceImpl getUser;

    @PostMapping("/login")
    public ResponseEntity<ResultDto> login(@RequestBody RequestDto<User> dto) {
         return new ResponseEntity(getUser.login(dto.getData()), HttpStatus.OK);
     /*   if (userBean.getPwd().equals(dto.getData().getPwd())) {
            return new ResponseEntity(JWTUtil.sign(userBean.getUname(), userBean.getPwd()),HttpStatus.OK);
        } else {
            throw new UnauthorizedException();
        }*/
    }

    @GetMapping("/article")
    public ResponseEntity<ResultDto> article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseEntity("You are already logged in", HttpStatus.OK);
        } else {
            return new ResponseEntity("You are guest", HttpStatus.OK);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseEntity<ResultDto> requireAuth() {
        return new ResponseEntity( "You are authenticated", HttpStatus.OK);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseEntity<ResultDto> requireRole() {
        return new ResponseEntity( "You are visiting require_role", HttpStatus.OK);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"1"})
    public ResponseEntity<ResultDto> requirePermission() {
        return new ResponseEntity( "You are visiting permission require edit,view", HttpStatus.OK);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ResultDto> unauthorized() {
        return new ResponseEntity("401", HttpStatus.OK);
    }
}