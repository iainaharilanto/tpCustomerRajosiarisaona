/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.rajosiarisaona.tpcustomerapplication.managedbeans;

import fr.rajosiarisaona.tpcustomerapplication.entities.Customer;
import fr.rajosiarisaona.tpcustomerapplication.entities.DiscountCode;
import fr.rajosiarisaona.tpcustomerapplication.session.CustomerManager;
import fr.rajosiarisaona.tpcustomerapplication.session.DiscountCodeManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Backing bean pour la page CustomerDetails.xhtml.
 */
@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable {
  private int idCustomer;
  private Customer customer;

  @EJB
  private CustomerManager customerManager;
  
  @EJB
  private DiscountCodeManager discountCodeManager;

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  /**
   * Retourne les détails du client courant (celui dans l'attribut customer de
   * cette classe), qu'on appelle une propriété (property)
     * @return 
   */
    public Customer getDetails() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer.
    customer = customerManager.update(customer);
    return "CustomerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.getCustomer(idCustomer);
  }
  
   public List<DiscountCode> getDiscountCodes() {
    return discountCodeManager.getAllDiscountCodes();
  }
   
   
}