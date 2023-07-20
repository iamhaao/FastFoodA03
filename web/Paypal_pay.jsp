<%-- 
    Document   : Paypal_pay.jsp
    Created on : Jul 17, 2023, 10:51:52 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<body>
    <script
        src="https://www.paypal.com/sdk/js?client-id=AZux1-97V62FhDsSr3nb379hYojfj5nA7WN7TKumGLzAOgFM0xa4MB2gTyRHS7Vqwb1zUybgU68NLM43"
        >
    </script>
    <div style="display: flex; justify-content: center">
        <div style="border: 0.5px solid #333; width: 800px; height: 300px;display: flex; flex-direction: column; justify-content: center;align-items: center; border-radius: 5px; box-shadow: 0 3px 8px #333; margin: 50px 0 " class="container">
            <div>
                <h1 class="text-center" style="margin-bottom: 30px; font-size: 22px; font-weight: 600; font-family: sans-serif">READY TO PAY</h1>
            </div>
            <div class="text-center">
                <!--<img width="50%" src="img/paypal-image.webp"/>-->
            </div>
            <div style="width: 500px" class="">
                <div id="paypal-button-container"></div>
            </div>
        </div>
    </div>

    <script>

        paypal
                .Buttons({
                    createOrder: function (data, actions) {
                        // This function sets up the details of the transaction, including the amount and line item details.
                        return actions.order.create({
                            purchase_units: [
                                {
                                    amount: {
                                        value: "${sessionScope.price_paypal}"
                                    }
                                }
                            ]
                        });
                    },
                    onApprove: function (data, actions) {

                        // This function captures the funds from the transaction.

                        return actions.order.capture().then(function (details) {
                            // This function shows a transaction success message to your buyer.
                            console.log(details.payer.payer_id)
                            if (details !== null || Object.keys(details).length !== 0) {
        <%
//                                    BookingDao bookingDao = new BookingDao();
//            
//                                    String[] bookingId =(String[]) session.getAttribute("listPay");
//                                    for(String booking : bookingId){
//                                      int id = Integer.parseInt(booking);
//                                      bookingDao.updateBookingStatus(id,"paid");
//                                      bookingDao.updateCodeAndPaidDate(id, null);
//                }
        %>
                                window.location = "CustomerPaypalPaymentServlet";
                            }
                        });

                    }
                })
                .render("#paypal-button-container");
        //This function displays Smart Payment Buttons on your web page.
    </script>
</body>
<%@include file="/includes/footer.jsp" %>