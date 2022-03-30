import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class making_file_name_unique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        String duplicateName;

        for (int i = 0 ; i < names.length; i++) {
            if (!map.containsKey((names[i]))) {
                map.put(names[i], 1);
                res[i] = names[i];
            } else {
                int suffix = map.get(names[i]);
                duplicateName = names[i] + "(" + suffix + ")";
                while (map.containsKey(duplicateName)) {
                    ++suffix;
                    duplicateName = names[i] + "(" + suffix + ")";
                }
                map.put(names[i], suffix);
                map.put(duplicateName, 1);
                res[i] = duplicateName;
            }
        }
        return res;
    }

    @Test
    public void testUniqueFileName() {
        String[] one = {"pes","fifa","gta","pes(2019)"};
        String[] expectedOne = {"pes","fifa","gta","pes(2019)"};
        String[] two = {"gta","gta(1)","gta","avalon"};
        String[] expectedTwo = {"gta","gta(1)","gta(2)","avalon"};
        String[] three = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        String[] expectedThree = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"};

        assertArrayEquals(expectedOne, getFolderNames(one));
        assertArrayEquals(expectedTwo, getFolderNames(two));
        assertArrayEquals(expectedThree, getFolderNames(three));
    }
}

/*
Explanation

Using a hashmap, if the filename doesn't exist, just add it in the hashmap and our result
If it does exist, we increment a suffix variable and assign with a duplicateName, then we have to loop and see if there already exist
that suffix name, if yes we increment suffix and assign it to the new name

Time: O(n)
Space: O(n) where n is the output array and the hash map
*/