package dao.api;

import dao.Dao;
import entity.UserInformation;
import exeptions.DaoException;


public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
