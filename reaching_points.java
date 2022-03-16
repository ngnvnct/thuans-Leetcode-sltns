import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class reaching_points {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (sx == tx && sy == ty) {
                return true;
            }
            if (tx > ty) {
                tx -= ty;
            } else {
                ty -= tx;
            }
        }
        return (tx == sx && ty == sy);
    }

    public boolean reachingPointsMod(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {
                break;
            }
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty;
                } else {
                    return (tx -sx) % ty == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx;
                } else {
                    return (ty - sy) % tx == 0;
                }
            }
        }
        return (tx == sx && ty == sy);
    }

    @Test
    public void testPoint() {
        assertEquals(true, reachingPointsMod(1,1,3,5));
        assertEquals(true, reachingPoints(1,1,3,5));
        assertEquals(false, reachingPointsMod(1,1,2,2));
        assertEquals(false, reachingPoints(1,1,2,2));
    }
}


/*abstract
Explanation

Naive method, every parent (x, y) has two children (x, x+y) (x+y, y)
but every point (x,y) only has one parent candidate (x-y, y) if x >= y else (x, y-x)
                     (2,5)
                (7,5)
                   (7, 12)
                (19,12)
Looking at previous success parents, we can find whether the starting point was an ancestor
If target is (19,12), the successive parents must have been (7,12), (7,5) and (2,5)
(2,5) is the starting point of (19,12)
Repeatedly subtract the smaller of tx,ty from the larger of tx,ty). The answer is true if we eventually reach sx,sy
TLE if one is really big (999999)

Optimal
source = (1,9) target (100,9)
100 mod 9 = (1,9)

Two Edge cases
source = (3,3) target (21,9)
21 mod 9 = 3 (3,9)
9 mod 3 = 0 <---- not the right answer

source = (2,3) target (2,11)
11 - 3 = 8 % 2 == 0, its true

source = (2,3) target (2,11)
Loop, at each call, check whether tx or ty is bigger than each other
tx in this case is smaller, then we check the target source with the root source if it is equal or not
because they are the same, we can just immediately return (ty - sy) % sx == 0, that means we can reach it (Edge case)
else, we can mod ty with tx

Time: O(max(tx,ty)), if ty = 1, we could be subtracting tx times
Space: O(1)
*/