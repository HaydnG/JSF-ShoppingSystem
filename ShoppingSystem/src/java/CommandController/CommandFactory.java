/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController;

import CommandController.Commands.RemoveUserCommand;
import CommandController.Commands.CreateProductCommand;
import CommandController.Commands.SetProductStateCommand;
import CommandController.Commands.ClearCartCommand;
import CommandController.Commands.GetOrdersCommand;
import CommandController.Commands.FindOrderCommand;
import CommandController.Commands.PlaceOrderCommand;
import CommandController.Commands.GetProductCommand;
import CommandController.Commands.GetShoppingCartCommand;
import CommandController.Commands.CountProductInCartCommand;
import CommandController.Commands.*;
import DTO.*;




/**
 *
 * @author haydn
 */
public class CommandFactory {
    
    
    public static final int FIND_USER = 1;
    public static final int HASH_PASSWORD = 2;
    public static final int ADD_USER = 3;
    public static final int ADD_ADDRESS = 4;
    public static final int USER_EXISTS = 5;
    public static final int GET_PRODUCTS = 6;
    public static final int GET_STORES = 7;
    public static final int COUNT_PRODUCT_IN_CART = 8;
    public static final int ADD_PRODUCT_IN_CART = 9;
    public static final int INCREMENT_PRODUCT_IN_CART = 10;
    public static final int DECREMENT_PRODUCT_IN_CART = 11;
    public static final int IS_PRODUCT_IN_CART = 12;
    public static final int GET_SHOPPING_CART = 13;
    public static final int GET_PRODUCT = 14;
    public static final int PLACE_ORDER = 15;
    public static final int FIND_ORDER = 16;
    public static final int GET_ORDERS = 17;
    public static final int CLEAR_CART = 18;
    public static final int SET_PRODUCT_STATE = 19;
    public static final int ADD_PRODUCT = 20;
    public static final int GET_USERS = 21;
    public static final int SET_USER_ROLE = 22;
    public static final int REMOVE_USER = 23;
    
    public static Command CreateCommand(int CommandID){

        switch (CommandID)
        {
            case GET_STORES:
                return new GetStoresCommand();
            default:
                return null;
        }
    }
    
    public static Command CreateCommand(int CommandID, Object DTO){

        switch (CommandID)
        {
            case FIND_USER:
                return new FindUserCommand((UserDTO) DTO);
            case HASH_PASSWORD:
                return new HashPasswordCommand((PasswordDTO) DTO);
            case ADD_USER:
                return new AddUserCommand((UserDTO) DTO);
            case ADD_ADDRESS:
                return new AddAddressCommand((AddressDTO) DTO);
            case USER_EXISTS:
                return new UserExistsCommand((UserDTO) DTO);
            case COUNT_PRODUCT_IN_CART:
                return new CountProductInCartCommand((UserDTO) DTO);
            case ADD_PRODUCT_IN_CART:
                return new AddProductInCartCommand((UserDTO) DTO);
            case INCREMENT_PRODUCT_IN_CART:
                return new IncrementProductInCartCommand((UserDTO) DTO);
            case DECREMENT_PRODUCT_IN_CART:
                return new DecrementProductInCartCommand((UserDTO) DTO);
            case IS_PRODUCT_IN_CART:
                return new IsProductInCartCommand((UserDTO) DTO);
            case GET_SHOPPING_CART:
                return new GetShoppingCartCommand((UserDTO) DTO);
            case GET_PRODUCT:
                return new GetProductCommand((ProductDTO) DTO);
            case PLACE_ORDER:
                return new PlaceOrderCommand((OrderDTO) DTO);
            case FIND_ORDER:
                return new FindOrderCommand((OrderDTO) DTO);
            case GET_ORDERS:
                return new GetOrdersCommand((UserDTO) DTO);
            case CLEAR_CART:
                return new ClearCartCommand((UserDTO) DTO);
            case SET_PRODUCT_STATE:
                return new SetProductStateCommand((ProductDTO) DTO);
            case ADD_PRODUCT:
                return new CreateProductCommand((ProductDTO) DTO);
            case GET_USERS:
                return new GetUsersCommand((UserDTO) DTO);
            case SET_USER_ROLE:
                return new SetUserRoleCommand((UserDTO) DTO);
            case REMOVE_USER:
                return new RemoveUserCommand((UserDTO) DTO);
            default:
                return null;
        }
    }
    
    public static Command CreateCommand(int CommandID, Object DTO, Object Extra, Object Extra2){

        switch (CommandID)
        { 
            case GET_PRODUCTS:
                return new GetProductsCommand((ProductDTO) DTO, (Boolean) Extra, (Boolean) Extra2);          
            default:
                return null;
        }
    }

    
}
