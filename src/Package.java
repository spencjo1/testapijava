public class Package {
    public static void sendTestRating() throws Exception {
        // Create a FoodRating object
        FoodRating rating = new FoodRating();
        rating.user_id = 1;
        rating.user_name = "Alice";
        rating.food_name = "Pizza";
        rating.rating = 5;
        rating.distance = 1.2;
        rating.open_time = 800;
        rating.close_time = 2200;

        // Call your Supabase helper to send it
        Senderr.sendRating(rating);
    }
}