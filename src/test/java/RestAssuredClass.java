import static io.restassured.RestAssured.*;

public class RestAssuredClass {
    final static String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    public static void getResponseBody() {
        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php")
                .then().log().body();
    }

    public static void getResponseStatus() {
        int statusCode = given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(url).getStatusCode();
        System.out.println("The response status is " + statusCode);

        given().when().get(url).then().assertThat().statusCode(400);
    }

    public static void main(String[] args) {
        getResponseStatus();
    }
}