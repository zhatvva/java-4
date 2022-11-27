package controller.command;

import controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}
