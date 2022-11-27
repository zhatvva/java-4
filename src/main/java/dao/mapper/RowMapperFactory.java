package dao.mapper;

import dao.mapper.impl.ApartmentRowMapper;
import dao.mapper.impl.RoleRowMapper;
import dao.mapper.impl.UserInformationRowMapper;
import dao.mapper.impl.UserOrderRowMapper;
import dao.mapper.impl.UserRowMapper;
import entity.Apartment;
import entity.Role;
import entity.User;
import entity.UserInformation;
import entity.UserOrder;
import com.labovich.lab4.dao.mapper.impl.*;
import com.labovich.lab4.entity.*;

public class RowMapperFactory {
    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final RowMapper<User> userRowMapper = new UserRowMapper();
    private final RowMapper<Role> roleRowMapper = new RoleRowMapper();
    private final RowMapper<UserInformation> userInformationRowMapper = new UserInformationRowMapper();
    private final RowMapper<UserOrder> userOrderRowMapper = new UserOrderRowMapper();
    private final RowMapper<Apartment> apartmentRowMapper = new ApartmentRowMapper();

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    public RowMapper<Role> getRoleRowMapper() {
        return roleRowMapper;
    }

    public RowMapper<UserInformation> getUserInformationRowMapper() {
        return userInformationRowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return userOrderRowMapper;
    }

    public RowMapper<Apartment> getApartmentRowMapper() {
        return apartmentRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
