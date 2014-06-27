package eu.socialsensor.framework.abstractions.socialmedia.flickr;

import com.flickr4java.flickr.people.User;

import eu.socialsensor.framework.common.domain.SocialNetworkSource;
import eu.socialsensor.framework.common.domain.StreamUser;

/**
 * Class that holds the information of a flickr user
 * @author ailiakop
 * @email  ailiakop@iti.gr
 */
public class FlickrStreamUser extends StreamUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511210498213084201L;

	public FlickrStreamUser(User user) {
		super(SocialNetworkSource.Flickr.toString(), Operation.NEW);
		if (user == null) return;
		
		//Id
		id = SocialNetworkSource.Flickr+"#"+user.getId();
		//The id of the user in the network
		userid = user.getId();
		//The name of the user
		name = user.getRealName();
		//The username of the user
		username = user.getUsername();
		//streamId
		streamId = SocialNetworkSource.Flickr.toString();
		//Profile picture of the user
		int iconFarm = user.getIconFarm();
		int iconServer = user.getIconServer();
		if(iconServer > 0) {
			profileImage = "http://farm" + iconFarm + ".staticflickr.com/" + iconServer 
					+ "/buddyicons/" + user.getId() + ".jpg";
		}
		else {
			profileImage = user.getBuddyIconUrl();
		}
		
			
		//Location
		location = user.getLocation();
		
		pageUrl = "https://www.flickr.com/photos/" + userid;
			
		items = user.getPhotosCount();
		
	}


}
