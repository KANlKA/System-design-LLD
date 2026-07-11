import java.util.BitSet;
public class BloomFilter {
    private final BitSet bitSet;
    private final int size;
    public BloomFilter(int size) {
        this.size = size;
        this.bitSet = new BitSet(size);
    }
    public void add(String value) {
        int h1 = hash1(value);
        int h2 = hash2(value);
        int h3 = hash3(value);
        bitSet.set(h1);
        bitSet.set(h2);
        bitSet.set(h3);
    }
    public boolean mightContain(String value) {
        int h1 = hash1(value);
        int h2 = hash2(value);
        int h3 = hash3(value);
        return bitSet.get(h1)
                && bitSet.get(h2)
                && bitSet.get(h3);
    }
    private int hash1(String s) {
        return Math.abs(s.hashCode()) % size;
    }
    private int hash2(String s) {
        return Math.abs((s.hashCode() * 31)) % size;
    }
    private int hash3(String s) {
        return Math.abs((s.hashCode() * 17 + 7)) % size;
    }
    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter(100);
        bf.add("Netflix");
        bf.add("Google");
        System.out.println(bf.mightContain("Netflix")); // true
        System.out.println(bf.mightContain("Amazon")); // probably false
    }
}
