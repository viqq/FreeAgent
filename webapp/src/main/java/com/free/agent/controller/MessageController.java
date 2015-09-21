package com.free.agent.controller;

import com.free.agent.Response;
import com.free.agent.dto.MessageDto;
import com.free.agent.model.Message;
import com.free.agent.service.MessageService;
import com.free.agent.utils.ExtractFunction;
import com.google.common.collect.Collections2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import static com.free.agent.FreeAgentAPI.*;

/**
 * Created by antonPC on 31.07.15.
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = GET_UNREAD_MESSAGES, method = RequestMethod.GET)
    public
    @ResponseBody
    String getq(Principal principal) {
        return Response.ok(messageService.countUnreadMessages(principal.getName()));
    }

    @RequestMapping(value = GET_ALL_MESSAGES, method = RequestMethod.GET)
    public
    @ResponseBody
    String get(Principal principal) {
        return Response.ok(Collections2.transform(messageService.findAllByReceiver(principal.getName()), ExtractFunction.MESSAGE_INVOKE));
    }

    @RequestMapping(value = GET_SENT_MESSAGES, method = RequestMethod.GET)
    public
    @ResponseBody
    String gett(Principal principal) {
        return Response.ok(messageService.findAllByAuthor(principal.getName()));
    }

    @RequestMapping(value = GET_HISTORY, method = RequestMethod.GET)
    public
    @ResponseBody
    String gett(Principal principal, @PathVariable("id") Long id) {
        return Response.ok(messageService.getHistory(principal.getName(), id));
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public
    @ResponseBody
    String get(MessageDto message, String email, Principal principal) {
        Message m = new Message();
        m.setText(message.getText());
        m.setTitle(message.getTitle());
        messageService.save(Long.parseLong(message.getId()), m, principal == null ? email : principal.getName());
        return Response.ok();
    }

    @RequestMapping(value = GET_MESSAGE_BY_ID, method = RequestMethod.POST)
    public
    @ResponseBody
    String get(@PathVariable("id") Long id, Principal principal) {
        messageService.updateMessageStatus(id, principal.getName());
        return Response.ok();
    }

}