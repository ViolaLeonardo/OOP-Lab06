package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	
	private String password;
	private String email;
	private Map<String, Set<U>> friends;


    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge, String password, String email) {
        super(name, surname, user, userAge);
        this.password = password;
        this.email = email;
        this.friends = new HashMap<>();
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user,  String password, String email) {
        this(name, surname, user, -1, password, email);
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	
    	Set<U> friendsGroup = this.friends.get(circle);
    	    	
    	if(friendsGroup == null){
    		friendsGroup = new HashSet<U>();
    		this.friends.put(circle, friendsGroup);
    	}
    	return friendsGroup.add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Set<U> friendsInCircle=  this.friends.get(groupName);
        if(friendsInCircle != null) {
        	return new ArrayList<>(friendsInCircle);
        }
        return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
    	
    	Set<U> followed = new HashSet<>();
    	for(Set<U> group: this.friends.values()) {
    		followed.addAll(group);		
    	}
        return new ArrayList<>(followed);
    }

}
