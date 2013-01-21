package com.proj.pages;

import com.proj.entities.User;
import com.proj.services.UserService;
import org.apache.click.ActionListener;
import org.apache.click.ActionResult;
import org.apache.click.Control;
import org.apache.click.Page;
import org.apache.click.ajax.AjaxBehavior;
import org.apache.click.ajax.DefaultAjaxBehavior;
import org.apache.click.control.Form;
import org.apache.click.control.PasswordField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasePage extends Page {

    @Autowired
    private UserService userService;

    private Form form = new Form("form");

    @Override
    public void onInit() {
        addControl(form);

        TextField login = new TextField("login");
        login.setMinLength(3);
        login.setRequired(true);
        form.add(login);
        form.add(new TextField("name"));
        form.add(new PasswordField("password"));
        form.add(new Submit("submit"));
        form.addBehavior(new DefaultAjaxBehavior() {
            @Override
            public ActionResult onAction(Control source) {
                if(form.isValid()){
                    User user = new User();
                    form.copyTo(user);
                    userService.save(user);
                } else {
                    System.out.println(form.getMessages().get("title"));
                }
                return new ActionResult("{result:ok}", ActionResult.JSON);
            }
        });
    }
}
