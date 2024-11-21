package by.tutorials.sweater;

import by.tutorials.sweater.domain.Message;
import by.tutorials.sweater.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

@Controller
public class GreatingController {
    @Autowired
    private  MessageRepo messageRepo;

    public GreatingController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("message", "Hello Sasha");
        return "main";

    }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
}
