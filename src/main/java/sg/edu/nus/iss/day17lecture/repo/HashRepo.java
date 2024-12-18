package sg.edu.nus.iss.day17lecture.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day17lecture.constant.Constant;


  @Repository
public class HashRepo {

    @Autowired
    @Qualifier(Constant.template01)
    private RedisTemplate<String, String> template;

    // Add or update a single key-value pair in a hash
    public void setMap(String folder, String key, String value) {
        template.opsForHash().put(folder, key, value);
    }

    // Add multiple key-value pairs to a hash
    public void setMapAll(String folder, HashMap<String, String> map) {
        template.opsForHash().putAll(folder, map);
    }

    // Retrieve a value for a specific key in a hash
    public String getValueFromMap(String folder, String key) {
        return (String) template.opsForHash().get(folder, key);
    }

    // Retrieve all key-value pairs in a hash
    public Map<Object, Object> getAllFromMap(String folder) {
        return template.opsForHash().entries(folder);
    }

    // Check if a key exists in a hash
    public boolean hasKey(String folder, String key) {
        return template.opsForHash().hasKey(folder, key);
    }

    // Delete a specific key from a hash
    public void deleteKeyFromMap(String folder, String key) {
        template.opsForHash().delete(folder, key);
    }

    // Retrieve all keys in a hash
    public Set<Object> getAllKeys(String folder) {
        return template.opsForHash().keys(folder);
    }

    // Retrieve all values in a hash
    public Set<Object> getAllValues(String folder) {
        return (Set<Object>) template.opsForHash().values(folder);
    }

    // Increment a numeric value in a hash
    public void incrementHashValue(String folder, String key, long delta) {
        template.opsForHash().increment(folder, key, delta);
    }

    // Increment a floating-point value in a hash
    public void incrementHashValue(String folder, String key, double delta) {
        template.opsForHash().increment(folder, key, delta);
    }

    // Get the size of a hash (number of keys)
    public long getHashSize(String folder) {
        return template.opsForHash().size(folder);
    }

    // Check if a hash exists
    public boolean hashExists(String folder) {
        return template.hasKey(folder);
    }
}



  
// Explanation of Methods:
// Basic Add/Update Methods:

// setMap: Add or update a single key-value pair in the hash.
// setMapAll: Add multiple key-value pairs at once.
// Retrieval Methods:

// getValueFromMap: Get the value for a specific key.
// getAllFromMap: Get all key-value pairs in the hash.
// getAllKeys: Get all the keys in the hash.
// getAllValues: Get all the values in the hash.
// Existence and Size Check:

// hasKey: Check if a key exists in the hash.
// getHashSize: Retrieve the size of the hash.
// Modification Methods:

// deleteKeyFromMap: Remove a specific key from the hash.
// incrementHashValue: Increment a numeric or floating-point value by a given delta.
// Hash Existence Check:

// hashExists: Check if the hash itself exists.
