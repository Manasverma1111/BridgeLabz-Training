package linkedlist;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

class SocialMedia {
    private UserNode head;

    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    public UserNode searchById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public UserNode searchByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) return;

        addFriend(u1, id2);
        addFriend(u2, id1);
    }

    private void addFriend(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;
    }

    public void removeFriendConnection(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) return;

        removeFriend(u1, id2);
        removeFriend(u2, id1);
    }

    private void removeFriend(UserNode user, int friendId) {
        FriendNode curr = user.friends;
        FriendNode prev = null;

        while (curr != null) {
            if (curr.friendId == friendId) {
                if (prev == null)
                    user.friends = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void findMutualFriends(int id1, int id2) {
        UserNode u1 = searchById(id1);
        UserNode u2 = searchById(id2);

        if (u1 == null || u2 == null) return;

        FriendNode f1 = u1.friends;
        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Mutual Friend ID: " + f1.friendId);
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }
    }

    public void displayFriends(int userId) {
        UserNode user = searchById(userId);
        if (user == null) return;

        FriendNode temp = user.friends;
        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    public void countFriendsForEachUser() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println("User ID: " + temp.userId + " | Friends Count: " + count);
            temp = temp.next;
        }
    }
}

public class SocialMediaConnection {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 21);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 23);
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);

        System.out.println("Friends of User 1:");
        sm.displayFriends(1);
        System.out.println("\nMutual friends of 1 and 2:");
        sm.findMutualFriends(1, 2);
        System.out.println("\nFriend counts:");
        sm.countFriendsForEachUser();

        sm.removeFriendConnection(1, 2);

        System.out.println("\nAfter removal, friends of User 1:");
        sm.displayFriends(1);
    }
}
