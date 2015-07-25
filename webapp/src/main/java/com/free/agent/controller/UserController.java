package com.free.agent.controller;


import com.free.agent.dto.UserDto;
import com.free.agent.model.Sport;
import com.free.agent.model.User;
import com.free.agent.service.SportService;
import com.free.agent.service.UserService;
import com.free.agent.utils.HttpRequestUtil;
import com.google.common.io.ByteStreams;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Created by antonPC on 21.06.15.
 */
@Controller
public class UserController {
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @Autowired
    private UserService userService;

    @Autowired
    private SportService sportService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getFilms() {
        return "registration";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String loginFormDe() {
        return "user";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String loginFormD() {
        return "info";
    }

    @RequestMapping(value = {"/", "/user-login", "/error-login"}, method = RequestMethod.GET)
    public String loginFormDef() {
        return "login-form";
    }

    @RequestMapping(value = "/sport", method = RequestMethod.GET)
    public Collection<Sport> getF() {
        return sportService.getAllSports();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void get(@Valid UserDto userDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            ///
        }
        Set<String> set = HttpRequestUtil.getParams(request, "select");
        userService.save(getUser(userDto), set);

    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public User getInf(Principal principal) {
        return userService.findByLogin(principal.getName());
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, Principal principal) throws IOException {
        ByteStreams.copy(new FileInputStream(userService.findByLogin(principal.getName()).getImage() + ".jpg"), response.getOutputStream());
    }

    @RequestMapping(value = "/user/setImage", method = RequestMethod.POST)
    public void setImage(HttpServletRequest request, Principal principal) throws IOException, FileUploadException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        @SuppressWarnings("unchecked")
        List<FileItem> multiparts = upload.parseRequest(request);
        userService.addImage(principal.getName(), multiparts);
    }

    private User getUser(UserDto userDto) {
        User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getPhone());
        user.setDescription(userDto.getDescription());
        user.setCity(userDto.getCity());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfRegistration(new Date());
        return user;
    }
}
