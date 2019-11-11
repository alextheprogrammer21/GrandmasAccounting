//Viper CSS from buckyroberts of Github
//Created by Alex S
//Created October 24, 2019
//GrandmasAccounting
package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    Stage window; Scene loginWindow; Scene mainWindow; TreeView<String> tree; BorderPane borderPane = new BorderPane(); int ordernumbers = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("GrandmasAccounting");
        Button neworderbutton = new Button("Submit"); Button updateorderbutton = new Button("Submit"); Button deleteorderbutton = new Button("Submit"); Button createbillofladingbutton = new Button("Submit"); Button deliverbillofladingbutton = new Button ("Submit"); Button viewopeninvoicebutton = new Button ("Submit"); Button emailinvoicesbutton = new Button ("Submit"); Button closeinvoicesbutton = new Button ("Submit"); Button newpurchasebutton = new Button ("Submit"); Button viewopenpurchbutton = new Button ("Submit"); Button paypurchasebutton = new Button ("Submit");


        //****************************SETTING UP GRIDPANE MENUS****************************//
        // GridPanes for each menu item
        /* New Order */
        GridPane neworder = new GridPane(); neworder.setPadding(new Insets(10, 10, 10, 10)); neworder.setVgap(8); neworder.setHgap(10);
        /* Update Order */
        GridPane updateorder = new GridPane(); updateorder.setPadding(new Insets(10, 10, 10, 10)); updateorder.setVgap(8); updateorder.setHgap(10);
        /* Delete Order */
        GridPane deleteorder = new GridPane(); deleteorder.setPadding(new Insets(10, 10, 10, 10)); deleteorder.setVgap(8); deleteorder.setHgap(10);
        /* Create BoL */
        GridPane createbilloflading = new GridPane(); createbilloflading.setPadding(new Insets(10, 10, 10, 10)); createbilloflading.setVgap(8); createbilloflading.setHgap(10);
        /* Mark Delivered */
        GridPane markasdelivered = new GridPane(); markasdelivered.setPadding(new Insets(10, 10, 10, 10)); markasdelivered.setVgap(8); markasdelivered.setHgap(10);
        /* View Open Invoices */
        GridPane viewopeninvoices = new GridPane(); viewopeninvoices.setPadding(new Insets(10, 10, 10, 10)); viewopeninvoices.setVgap(8); viewopeninvoices.setHgap(10);
        /* Email Invoices */
        GridPane emailinvoices = new GridPane(); emailinvoices.setPadding(new Insets(10, 10, 10, 10)); emailinvoices.setVgap(8); emailinvoices.setHgap(10);
        /* Close Invoices */
        GridPane closeinvoice = new GridPane(); closeinvoice.setPadding(new Insets(10, 10, 10, 10)); closeinvoice.setVgap(8); closeinvoice.setHgap(10);
        /* New Purchases */
        GridPane newpurchase = new GridPane(); newpurchase.setPadding(new Insets(10, 10, 10, 10)); newpurchase.setVgap(8); newpurchase.setHgap(10);
        /* View Purchases */
        GridPane viewopenpurchases = new GridPane(); viewopenpurchases.setPadding(new Insets(10, 10, 10, 10)); viewopenpurchases.setVgap(8); viewopenpurchases.setHgap(10);
        /* Pay Purchases */
        GridPane paypurchase = new GridPane(); paypurchase.setPadding(new Insets(10, 10, 10, 10)); paypurchase.setVgap(8); paypurchase.setHgap(10);
        /* Login Grid */
        GridPane grid = new GridPane(); grid.setPadding(new Insets(10, 10, 10, 10)); grid.setVgap(8); grid.setHgap(10); Label nameLabel = new Label("Username:"); nameLabel.setId("bold-label"); GridPane.setConstraints(nameLabel, 0, 0); TextField nameInput = new TextField("Alex"); GridPane.setConstraints(nameInput, 1, 0); Label passLabel = new Label("Password:"); GridPane.setConstraints(passLabel, 0, 1); TextField passInput = new TextField(); passInput.setPromptText("password"); GridPane.setConstraints(passInput, 1, 1); Button loginButton = new Button("Log In"); GridPane.setConstraints(loginButton, 1, 2); loginButton.setOnAction(e -> window.setScene(mainWindow));

        //Creating the gui form for each menu item
        /* New Order */
        TextField customertextfield = new TextField(); TextField costtextfield = new TextField(); TextField salepricetextfield = new TextField(); Label customerlabel = new Label("Customer:"); customerlabel.setId("bold-label"); Label costlabel = new Label("Cost:"); costlabel.setId("bold-label"); Label salepricelabel = new Label("Sale Price:"); salepricelabel.setId("bold-label"); GridPane.setConstraints(customerlabel, 0, 0); GridPane.setConstraints(costlabel, 0, 1); GridPane.setConstraints(salepricelabel, 0, 2); GridPane.setConstraints(customertextfield, 1, 0); GridPane.setConstraints(costtextfield, 1, 1); GridPane.setConstraints(salepricetextfield, 1, 2); GridPane.setConstraints(neworderbutton, 0, 4); GridPane.setConstraints(updateorderbutton, 0, 4);
        /* Update Order */
        TextField customertextfield1 = new TextField(); TextField costtextfield1 = new TextField(); TextField salepricetextfield1 = new TextField(); TextField ordernumbertextfield1 = new TextField(); Label ordernumberlabel1 = new Label("Order Number:"); ordernumberlabel1.setId("bold-label"); Label customerlabel1 = new Label("Customer:"); customerlabel1.setId("bold-label"); Label costlabel1 = new Label("Cost:"); costlabel1.setId("bold-label"); Label salepricelabel1 = new Label("Sale Price:"); salepricelabel1.setId("bold-label"); GridPane.setConstraints(ordernumberlabel1, 0, 0); GridPane.setConstraints(ordernumbertextfield1, 1, 0); GridPane.setConstraints(customerlabel1, 0, 1); GridPane.setConstraints(costlabel1, 0, 2); GridPane.setConstraints(salepricelabel1, 0, 3); GridPane.setConstraints(customertextfield1, 1, 1); GridPane.setConstraints(costtextfield1, 1, 2); GridPane.setConstraints(salepricetextfield1, 1, 3); GridPane.setConstraints(updateorderbutton, 0, 5);
        /* Delete Order */
        TextField ordernumbertextfield2 = new TextField(); Label ordernumberlabel2 = new Label("Order Number:"); ordernumberlabel2.setId("bold-label"); GridPane.setConstraints(ordernumberlabel2, 0,0); GridPane.setConstraints(ordernumbertextfield2, 1,0); GridPane.setConstraints(deleteorderbutton, 0,1);
        /* Create BoL */
        TextField ordernumbertextfield3 = new TextField(); Label ordernumberlabel3 = new Label("Order number ready for delivery:"); ordernumberlabel3.setId("bold-label"); GridPane.setConstraints(ordernumberlabel2, 0,0); GridPane.setConstraints(ordernumbertextfield3, 1,0); GridPane.setConstraints(createbillofladingbutton, 0,1);
        /* Deliver BoL */
        TextField billofladingnumbertextfield1 = new TextField(); Label billofladingnumberlabel1 = new Label("Order number:"); billofladingnumberlabel1.setId("bold-label"); GridPane.setConstraints(billofladingnumberlabel1, 0,0); GridPane.setConstraints(billofladingnumbertextfield1,1,0); GridPane.setConstraints(deliverbillofladingbutton,0,2);
        /* View Open Invoices */
        TextField invoicenumbertextfield = new TextField(); Label invoicenumberlabel = new Label("Invoice number:"); invoicenumberlabel.setId("bold-label"); GridPane.setConstraints(invoicenumberlabel, 0,0); GridPane.setConstraints(invoicenumbertextfield,1,0); GridPane.setConstraints(viewopeninvoicebutton,0,2);
        /* Email Invoices */
        TextField invoicenumbertextfield1 = new TextField(); TextField emailtextfield1 = new TextField(); Label invoicenumberlabel1 = new Label("Invoice number:"); invoicenumberlabel1.setId("bold-label"); Label emaillabel = new Label("Email address:"); emaillabel.setId("bold-label"); GridPane.setConstraints(invoicenumberlabel1, 0,0); GridPane.setConstraints(invoicenumbertextfield1,1,0); GridPane.setConstraints(emaillabel,0,1); GridPane.setConstraints(emailtextfield1,1,1); GridPane.setConstraints(emailinvoicesbutton,0,3);
        /* Close Invoices */
        TextField invoicenumbertextfield2 = new TextField(); Label invoicenumberlabel2 = new Label("Invoice number:"); invoicenumberlabel2.setId("bold-label"); GridPane.setConstraints(invoicenumberlabel2, 0,0); GridPane.setConstraints(invoicenumbertextfield2,1,0); GridPane.setConstraints(closeinvoicesbutton,0,2);
        /* New Purchase */
        TextField companypurchasetext = new TextField(); TextField purchaseitemtext = new TextField(); TextField purchasecosttext = new TextField(); Label companypurchaselabel = new Label("Company:"); Label purchaseitemlabel = new Label("Item:"); Label purchasecostlabel = new Label("Cost:"); companypurchaselabel.setId("bold-label"); purchasecostlabel.setId("bold-label"); purchaseitemlabel.setId("bold-label"); GridPane.setConstraints(companypurchaselabel,0,0); GridPane.setConstraints(purchaseitemlabel,0,1); GridPane.setConstraints(purchasecostlabel,0,2); GridPane.setConstraints(companypurchasetext,1,0); GridPane.setConstraints(purchaseitemtext,1,1); GridPane.setConstraints(purchasecosttext,1,2); GridPane.setConstraints(newpurchasebutton,0,4);
        /* View Open Purchases */
        TextField viewopenpurchtf = new TextField(); Label viewopenpurchlabel = new Label("Invoice number:"); viewopenpurchlabel.setId("bold-label"); GridPane.setConstraints(viewopenpurchlabel, 0,0); GridPane.setConstraints(viewopenpurchtf,1,0); GridPane.setConstraints(viewopenpurchbutton,0,2);
        /* Pay Purchases */
        TextField paypurchasetf = new TextField(); Label paypurchaselabel = new Label("Invoice number:"); paypurchaselabel.setId("bold-label"); GridPane.setConstraints(paypurchaselabel, 0,0); GridPane.setConstraints(paypurchasetf,1,0); GridPane.setConstraints(paypurchasebutton,0,2);

        //***********************SETTING UP TREE MENU*****************************//
        TreeItem<String> root, booking, shipping, invoicing, accountsPayable;
        root = new TreeItem<>(); root.setExpanded(true);
        //booking
        booking = makeBranch("Booking", root); makeBranch("New Order", booking); makeBranch("Update Order", booking); makeBranch("Delete Order", booking);
        //shipping
        shipping = makeBranch("Shipping", root); makeBranch("Create Bill of Lading", shipping); makeBranch("Mark as Delivered", shipping);
        //invoicing
        invoicing = makeBranch("Invoicing", root); makeBranch("View Open Invoices", invoicing); makeBranch("Email Invoices", invoicing); makeBranch("Close Invoice", invoicing);
        //accountsPayable
        accountsPayable = makeBranch("accountsPayable", root); makeBranch("New Purchase", accountsPayable); makeBranch("View Open Purchase", accountsPayable); makeBranch("Pay Purchase", accountsPayable);

        //Create the tree and hide the main Root
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        if (newValue.getValue() == "New Order") { borderPane.setCenter(neworder); }
                    if (newValue.getValue() == "Update Order") { borderPane.setCenter(updateorder); }
                    if (newValue.getValue() == "Delete Order") { borderPane.setCenter(deleteorder); }
                    if (newValue.getValue() == "Create Bill of Lading") { borderPane.setCenter(createbilloflading); }
                    if (newValue.getValue() == "Mark as Delivered") { borderPane.setCenter(markasdelivered); }
                    if (newValue.getValue() == "View Open Invoices") { borderPane.setCenter(viewopeninvoices); }
                    if (newValue.getValue() == "Email Invoices") { borderPane.setCenter(emailinvoices); }
                    if (newValue.getValue() == "Close Invoice") { borderPane.setCenter(closeinvoice); }
                    if (newValue.getValue() == "New Purchase") { borderPane.setCenter(newpurchase); }
                    if (newValue.getValue() == "View Open Purchase") { borderPane.setCenter(viewopenpurchases); }
                    if (newValue.getValue() == "Pay Purchase") { borderPane.setCenter(paypurchase); }
                });


        //****************************ACTION BUTTONS*******************************//

        neworderbutton.setOnAction(e -> {
            try {
                Databases.insertorder(Databases.getordernumber(), customertextfield.getText(), Integer.parseInt(costtextfield.getText()), Integer.parseInt(salepricetextfield.getText()), "open", "NotReady");
                Alertbox.display("Order confirmed");
                Databases.selectAll();
            } catch (NumberFormatException error) {
                Alertbox.display("Error. Please insert a number for the cost and sales price.");
            }
        });

        updateorderbutton.setOnAction(e -> {
Databases.searchordernumber(10);
Alertbox.display("Functionality coming soon.");
        });

        deleteorderbutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        createbillofladingbutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        deliverbillofladingbutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        viewopeninvoicebutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        emailinvoicesbutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        closeinvoicesbutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        newpurchasebutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        viewopenpurchbutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });

        paypurchasebutton.setOnAction(e -> {
            Alertbox.display("Functionality coming soon.");
        });
        //***************************************SETUP TO RUN*********************************************//
        //BorderPane for main Window
        VBox leftMenu = new VBox();
        leftMenu.getChildren().addAll(tree);
        borderPane.setLeft(leftMenu);

        //Adding all items to the grids
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        neworder.getChildren().addAll(customerlabel, customertextfield, costlabel, costtextfield, salepricelabel, salepricetextfield, neworderbutton);
        updateorder.getChildren().addAll(ordernumberlabel1, ordernumbertextfield1, customerlabel1,customertextfield1, costlabel1, costtextfield1, salepricelabel1, salepricetextfield1, updateorderbutton);
        deleteorder.getChildren().addAll(ordernumberlabel2, ordernumbertextfield2, deleteorderbutton);
        createbilloflading.getChildren().addAll(ordernumberlabel3, ordernumbertextfield3, createbillofladingbutton);
        markasdelivered.getChildren().addAll(billofladingnumberlabel1, billofladingnumbertextfield1, deliverbillofladingbutton);
        viewopeninvoices.getChildren().addAll(invoicenumberlabel, invoicenumbertextfield, viewopeninvoicebutton);
        emailinvoices.getChildren().addAll(invoicenumberlabel1, invoicenumbertextfield1, emaillabel, emailtextfield1, emailinvoicesbutton);
        closeinvoice.getChildren().addAll(invoicenumberlabel2, invoicenumbertextfield2, closeinvoicesbutton);
        newpurchase.getChildren().addAll(companypurchaselabel, companypurchasetext, purchasecostlabel, purchasecosttext, purchaseitemlabel, purchaseitemtext, newpurchasebutton);
        viewopenpurchases.getChildren().addAll(viewopenpurchtf, viewopenpurchlabel, viewopenpurchbutton);
        paypurchase.getChildren().addAll(paypurchaselabel, paypurchasetf, paypurchasebutton);

        //Other stuff to run
        loginWindow = new Scene(grid, 300, 200);
        mainWindow = new Scene(borderPane, 800, 300);
        loginWindow.getStylesheets().add("Viper.css");
        mainWindow.getStylesheets().add("Viper.css");
        tree.getStylesheets().add("Viper.css");
        window.setScene(loginWindow);
        window.show();
    }

    //************************************ADDITIONAL FUNCTIONS***********************************//
    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        Databases.createtables();
        launch(args);
    }
}
