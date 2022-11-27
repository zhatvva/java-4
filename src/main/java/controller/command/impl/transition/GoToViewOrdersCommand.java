package controller.command.impl.transition;

import controller.command.Command;
import controller.command.CommandResult;
import controller.command.CommandResultType;
import controller.context.RequestContext;
import controller.context.RequestContextHelper;
import entity.Apartment;
import entity.User;
import entity.UserInformation;
import entity.UserOrder;
import exeptions.ServiceException;
import service.ServiceFactory;
import service.api.ApartmentService;
import service.api.UserInformationService;
import service.api.UserOrderService;
import service.api.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToViewOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/viewOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String USERS = "users";
    private static final String APARTMENTS = "apartments";
    private static final String USER_INFORMATION = "userInformation";
    private static final String EXPECTED = "booked";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {


            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders = userOrderService.retrieveUserOrderByStatus(EXPECTED);
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);



            UserService userService = ServiceFactory.getInstance().getUserService();
            List<User> users = userService.getUsersFromOrders(userOrders);
            requestContext.addRequestAttribute(USERS, users);

            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments=apartmentService.retrieveApartamentsByUserOrders(userOrders);
            requestContext.addRequestAttribute(APARTMENTS, apartments);

            UserInformationService userInformationService = ServiceFactory.getInstance().getUserInformationService();
            List<UserInformation> userInformation = userInformationService.getUserInformationFromUsers(users);
            requestContext.addRequestAttribute(USER_INFORMATION, userInformation);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
