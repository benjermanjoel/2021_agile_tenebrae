/*
* The CampaignDAOException class defines a custom exception for the project.
* */

package dao;
/*
    The CampaignDAOException class extends Exception that provides for custom exceptions in our web application
*/
public class CampaignDAOException extends Exception{
    public CampaignDAOException (final String message){
        super(message);
    }
}
