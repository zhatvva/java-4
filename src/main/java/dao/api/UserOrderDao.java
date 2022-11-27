package dao.api;

import dao.Dao;
import entity.UserOrder;
import exeptions.DaoException;

import java.sql.Timestamp;
import java.util.List;

public interface UserOrderDao extends Dao<UserOrder> {


    List<UserOrder> findByStatus(String status) throws DaoException;

    List<UserOrder> findByUserId(int userId) throws DaoException;

    List<UserOrder> findByNotThisTime(Timestamp startTime,int leaseDuration) throws DaoException;

    void updateStatusById(long id, String status) throws DaoException;

    List<UserOrder> findByApartmentID(int apartmentId) throws DaoException;

}
