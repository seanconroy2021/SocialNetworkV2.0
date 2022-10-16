public class Driver {

    private NewsFeed newsFeed = new NewsFeed();

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        runMenu();
    }

    private int mainMenu(){
        return ScannerInput.readNextInt("""
               Social Network Menu
                  ---------------------
                  1) Add a Message Post
                  2) List all Posts
                  3) Update a Message Post
                  4) Delete a Message Post
                  ---------------------
                  0) Exit
               ==>>  """);
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addMessagePost();
                case 2 -> showPosts();
                case 3 -> updateMaessagePost();
                case 4 -> deleteMessagePost();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    // new code

    private void updateMaessagePost()
    {
        showPosts();  // this will lists all the messages
        if (newsFeed.numberOfPosts() > 0)
        {
            //check to see if the index is valid or not wont allow the user to continue
            int indexUpdate = ScannerInput.readNextInt("enter the index of the message to update ==> ");
            if (newsFeed.isValidIndex(indexUpdate)){
                String author = ScannerInput.readNextLine("enter the Author Name:  ");
                String message = ScannerInput.readNextLine("enter the Message:  ");

                //pass them in and if it returns true meaning success.
                if (newsFeed.updateMessagePost(indexUpdate, new MessagePost(author, message))){
                    System.out.println("update Successful");
                }
                else{
                    System.out.println("update NOT Successful");
                }
            }
            else{
                System.out.println("there are no messages for this index number");
            }
        }
    }

    public void deleteMessagePost() {
        if (newsFeed.numberOfPosts() > 0) {
            // the user will input what it wants to delete
            int indexDelete = ScannerInput.readNextInt("Enter the index of the messgae post to delete ==> ");

            MessagePost messagePostToDeleted = newsFeed.deleteMessagePost(indexDelete);
            if (messagePostToDeleted != null) {
                System.out.println("Delete Successful! Deleted message post: " + messagePostToDeleted.display());
            }
        } else {
            System.out.println("delete not successful");
        }
    }



    //gather the message post data from the user and add the new message post object to the arraylist
    private void addMessagePost(){

        String authorName = ScannerInput.readNextLine("Enter the Author Name:  ");
        String message = ScannerInput.readNextLine("Enter the Message:  ");

        boolean isAdded = newsFeed.addPost(new MessagePost(authorName, message));
        if (isAdded){
            System.out.println("Post Added Successfully");
        }
        else{
            System.out.println("No Post Added");
        }
    }

    //print the posts in newsfeed i.e. array list.
    private void showPosts(){
        System.out.println("List of Messages are:");
        System.out.println(newsFeed.show());
    }

}
