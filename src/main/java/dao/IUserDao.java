package dao;

import model.Product;
import model.User;

import java.util.List;

public interface IUserDao {
     List<User> listUser();

     List<User> listBuyer();

    User findBuyerById(int buyerID);

    void saveBuyer(User buyer);

    User findBuyerByEmail(String buyerEmail);

    void updateUser(User updatedUser);

    public void deleteUser(int id);
}
