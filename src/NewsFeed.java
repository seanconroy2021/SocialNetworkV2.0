import java.util.ArrayList;

public class NewsFeed {

    private ArrayList<MessagePost> posts;

    public NewsFeed() {
        posts = new ArrayList<MessagePost>();
    }

    public boolean addPost(MessagePost post) {
        return posts.add(post);
    }

    public String show() {
        String str = "";

        for(MessagePost post : posts) {
            str += posts.indexOf(post) + ": " + post.display() + "\n";
        }

        if (str.isEmpty()){
            return "No Posts";
        }
        else {
            return str;
        }
    }


    // new code for week 5 ---

    public int numberOfPosts()
    {
        return  posts.size();
    }

    public boolean isValidIndex(int index)
    {
        return (index>=0)&& (index<posts.size()); // returns true if the index passed as a parameter is a valid index in the posts ArrayList, false otherwise.
    }


    public MessagePost findMessagePost(int index)
    {
        if (isValidIndex(index))
        {
            return posts.get(index);
        }

        return null;
    }
    public MessagePost deleteMessagePost(int indexToDelete)
    {
        if (isValidIndex(indexToDelete))
        {
            return posts.remove(indexToDelete);
        }
        return null;
    }
    // new part
    public boolean updateMessagePost(int indexUpdate, MessagePost updateDetails)
    {
        //find the product by the index number
        MessagePost foundMessage = findMessagePost(indexUpdate);

    //if the message exists, use the details passed in the updateDetails parameter to

        if (foundMessage != null) {
            foundMessage.setAuthor(updateDetails.getAuthor());
            foundMessage.setMessage(updateDetails.getMessage());
        return true;
    }

    //if it cant find it will send false back
        return false;
}




}




