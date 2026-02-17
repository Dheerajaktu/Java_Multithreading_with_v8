package internalWorkingInJava;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapInternalWorking {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("HASHMAP COMPLETE WORKING EXAMPLE");
        System.out.println("=".repeat(70));


        section1_BasicOperations();
        section2_CustomObjects();
        section3_CollisionHandling();
        section4_ImportantMethods();
        section5_PerformanceAnalysis();
        section6_ThreadSafety();
    }

    static void section1_BasicOperations() {

        HashMap<String , Integer> map = new HashMap<>();

        // PUT Operation
        System.out.println("\n1. PUT Operation (Adding elements):");
        System.out.println("──────────────────────────────");

        map.put("Raj", 25);
        System.out.println("✓ put(\"Raj\", 25) → Size: " + map.size());

        map.put("Priya", 23);
        System.out.println("✓ put(\"Priya\", 23) → Size: " + map.size());

        map.put("Aman", 26);
        System.out.println("✓ put(\"Aman\", 26) → Size: " + map.size());

        map.put("Neha", 24);
        System.out.println("✓ put(\"Neha\", 24) → Size: " + map.size());

        // UPDATE Operation
        System.out.println("\n2. UPDATE Operation (Same key):");
        System.out.println("──────────────────────────────");

        Integer oldValue = map.put("Raj", 26);
        System.out.println("✓ put(\"Raj\", 26) → Old value: " + oldValue);
        System.out.println("✓ New value in map: " + map.get("Raj"));
        System.out.println("✓ Size still: " + map.size() + " (no duplicate)");

        // GET Operation
        System.out.println("\n3. GET Operation (Retrieving elements):");
        System.out.println("──────────────────────────────────────");

        System.out.println("✓ get(\"Raj\") = " + map.get("Raj"));
        System.out.println("✓ get(\"Priya\") = " + map.get("Priya"));
        System.out.println("✓ get(\"Unknown\") = " + map.get("Unknown")); // null
        System.out.println("✓ getOrDefault(\"Unknown\", 0) = " + map.getOrDefault("Unknown", 0));

        // Check existence
        System.out.println("\n4. Check Existence:");
        System.out.println("──────────────────────────────");

        System.out.println("✓ containsKey(\"Raj\") = " + map.containsKey("Raj"));
        System.out.println("✓ containsKey(\"Unknown\") = " + map.containsKey("Unknown"));
        System.out.println("✓ containsValue(26) = " + map.containsValue(26));
        System.out.println("✓ containsValue(999) = " + map.containsValue(999));

        // Remove operation
        System.out.println("\n5. REMOVE Operation:");
        System.out.println("──────────────────────────────");

        Integer removed = map.remove("Neha");
        System.out.println("✓ remove(\"Neha\") → Removed value: " + removed);
        System.out.println("✓ Size after remove: " + map.size());
        System.out.println("✓ containsKey(\"Neha\") = " + map.containsKey("Neha"));

        // Iteration
        System.out.println("\n6. Iteration:");
        System.out.println("──────────────────────────────");

        System.out.println("✓ Current map:");
        map.forEach((key, value) -> System.out.println("  " + key + " → " + value));

        System.out.println("✓ Map size: " + map.size());
        System.out.println("✓ Map isEmpty: " + map.isEmpty());

    }

    static void section2_CustomObjects() {
        System.out.println("\n" + "▶".repeat(35));
        System.out.println("SECTION 2: CUSTOM OBJECTS AS KEYS");
        System.out.println("▶".repeat(35));

        HashMap<Employee, String> departmentMap = new HashMap<>();

        System.out.println("\n1. Creating Employee objects:");
        System.out.println("──────────────────────────────────");

        Employee emp1 = new Employee(101, "Raj Kumar", 50000);
        Employee emp2 = new Employee(102, "Priya Singh", 55000);
        Employee emp3 = new Employee(103, "Aman Verma", 52000);

        System.out.println("✓ " + emp1);
        System.out.println("✓ " + emp2);
        System.out.println("✓ " + emp3);

        // Add to HashMap
        System.out.println("\n2. Adding to HashMap:");
        System.out.println("──────────────────────────────");

        departmentMap.put(emp1, "Engineering");
        departmentMap.put(emp2, "Finance");
        departmentMap.put(emp3, "HR");

        System.out.println("✓ Added 3 employees");
        System.out.println("✓ HashMap size: " + departmentMap.size());

        // Retrieve using Employee object
        System.out.println("\n3. Retrieving using Employee key:");
        System.out.println("──────────────────────────────");

        String dept = departmentMap.get(emp1);
        System.out.println("✓ Department of " + emp1.name + ": " + dept);

        // Important: Same hashCode and equals = Same object in HashMap
        System.out.println("\n4. Important: hashCode and equals relationship:");
        System.out.println("──────────────────────────────────────────────────");

        Employee emp1_duplicate = new Employee(101, "Raj Kumar", 60000);
        System.out.println("✓ Created new Employee(101, 'Raj Kumar', 60000)");
        System.out.println("✓ emp1 hashCode: " + emp1.hashCode());
        System.out.println("✓ emp1_duplicate hashCode: " + emp1_duplicate.hashCode());
        System.out.println("✓ emp1.equals(emp1_duplicate): " + emp1.equals(emp1_duplicate));
        System.out.println("✓ departmentMap.get(emp1_duplicate): " + departmentMap.get(emp1_duplicate));
        System.out.println("⚠️  SAME ENTRY! Because equals returned true");

        // Update using different object
        System.out.println("\n5. Update using equivalent object:");
        System.out.println("──────────────────────────────");

        departmentMap.put(emp1_duplicate, "Management");
        System.out.println("✓ Updated department using emp1_duplicate");
        System.out.println("✓ departmentMap.get(emp1): " + departmentMap.get(emp1));
        System.out.println("✓ Size still 3 (not 4)");

        // All entries
        System.out.println("\n6. All employee-department mappings:");
        System.out.println("──────────────────────────────");

        departmentMap.forEach((employee, department) ->
                System.out.println("✓ " + employee + " → " + department)
        );
    }

    static void section3_CollisionHandling() {
        System.out.println("\n" + "▶".repeat(35));
        System.out.println("SECTION 3: COLLISION HANDLING");
        System.out.println("▶".repeat(35));

        HashMap<String, String> map = new HashMap<>();

        System.out.println("\n1. Understanding Collisions:");
        System.out.println("────────────────────────────");
        System.out.println("""
            When two different keys hash to same bucket:
            bucket[6] → Node1(key="Raj") → Node2(key="Aman")
            
            This is resolved by chaining (LinkedList).
            In Java 8+, if chain > 8, converts to Red-Black Tree.
        """);

        // Add multiple entries
        String[] keys = {"A", "B", "C", "D", "E", "F"};

        System.out.println("\n2. Adding entries:");
        System.out.println("──────────────────────────");

        for (String key : keys) {
            map.put(key, "Value_" + key);
            System.out.println("✓ put(\"" + key + "\", \"Value_" + key + "\") → Size: " + map.size());
        }

        System.out.println("\n3. Internal Structure (Simplified):");
        System.out.println("─────────────────────────────────");
        System.out.println("""
            HashMap has internal array with bucket[0..15]
            Each bucket can contain multiple entries (collision chain):
            
            bucket[i] → Node1 → Node2 → Node3
                        (linked via 'next' pointer)
            
            When retrieving get("A"):
            1. Calculate hashCode("A")
            2. Find bucket index
            3. Traverse chain to find matching key
            4. Return value
        """);

        System.out.println("\n4. Retrieval from collision chain:");
        System.out.println("──────────────────────────────────");

        for (String key : keys) {
            String value = map.get(key);
            System.out.println("✓ get(\"" + key + "\") = " + value);
        }

        System.out.println("\n5. Load Factor & Resizing:");
        System.out.println("─────────────────────────");
        System.out.println("""
            Load Factor = size / capacity
            Default = 0.75
            
            Initial: capacity=16, threshold=12
            When size > 12:
            → New capacity = 32
            → All entries rehashed (O(n) operation)
            → New threshold = 24
            
            This is why put() is "amortized O(1)"
        """);
    }

    static void section4_ImportantMethods() {
        System.out.println("\n" + "▶".repeat(35));
        System.out.println("SECTION 4: IMPORTANT METHODS");
        System.out.println("▶".repeat(35));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        System.out.println("\n1. Iteration Methods (Most to Least Efficient):");
        System.out.println("───────────────────────────────────────────────");

        // entrySet (BEST)
        System.out.println("\n✓ Using entrySet() (BEST for performance):");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue());
        }

        // keySet
        System.out.println("\n✓ Using keySet():");
        for (String key : map.keySet()) {
            System.out.println("  " + key);
        }

        // values
        System.out.println("\n✓ Using values():");
        for (Integer value : map.values()) {
            System.out.println("  " + value);
        }

        // forEach (Java 8+)
        System.out.println("\n✓ Using forEach():");
        map.forEach((key, value) -> System.out.println("  " + key + " → " + value));

        System.out.println("\n2. Conditional Operations:");
        System.out.println("─────────────────────────");

        // putIfAbsent
        System.out.println("\n✓ putIfAbsent(key, value):");
        map.putIfAbsent("A", 100);  // Won't add (A exists)
        System.out.println("  putIfAbsent(\"A\", 100) → Value: " + map.get("A"));

        map.putIfAbsent("D", 40);   // Will add (D doesn't exist)
        System.out.println("  putIfAbsent(\"D\", 40) → Value: " + map.get("D"));

        // getOrDefault
        System.out.println("\n✓ getOrDefault(key, defaultValue):");
        System.out.println("  getOrDefault(\"A\", 0) = " + map.getOrDefault("A", 0));
        System.out.println("  getOrDefault(\"Z\", 0) = " + map.getOrDefault("Z", 0));

        // computeIfPresent
        System.out.println("\n✓ computeIfPresent(key, function):");
        map.computeIfPresent("A", (k, v) -> v * 2);
        System.out.println("  computeIfPresent(\"A\", v -> v*2) → " + map.get("A"));

        // computeIfAbsent
        System.out.println("\n✓ computeIfAbsent(key, function):");
        map.computeIfAbsent("E", k -> 50);
        System.out.println("  computeIfAbsent(\"E\", 50) → " + map.get("E"));

        // merge
        System.out.println("\n✓ merge(key, value, remappingFunction):");
        map.merge("B", 5, Integer::sum);
        System.out.println("  merge(\"B\", 5, Integer::sum) → " + map.get("B"));

        System.out.println("\n3. Other Methods:");
        System.out.println("─────────────────");

        System.out.println("\n✓ size() = " + map.size());
        System.out.println("✓ isEmpty() = " + map.isEmpty());

        // Remove
        System.out.println("\n✓ remove() methods:");
        map.remove("C");
        System.out.println("  remove(\"C\") → C removed");
        System.out.println("  size now: " + map.size());
    }

    static void section5_PerformanceAnalysis() {
        System.out.println("\n" + "▶".repeat(35));
        System.out.println("SECTION 5: PERFORMANCE ANALYSIS");
        System.out.println("▶".repeat(35));

        System.out.println("\n1. Time Complexity:");
        System.out.println("──────────────────");
        System.out.println("""
            ┌─────────┬──────────┬─────────┬──────────┐
            │Operation│Best Case │Avg Case │Worst Case│
            ├─────────┼──────────┼─────────┼──────────┤
            │get()    │   O(1)   │  O(1)   │   O(n)   │
            │put()    │   O(1)   │  O(1)   │   O(n)   │
            │remove() │   O(1)   │  O(1)   │   O(n)   │
            │iterate()│   O(n)   │  O(n)   │   O(n)   │
            └─────────┴──────────┴─────────┴──────────┘
            
            Average O(1): Good hash distribution + load factor 0.75
            Worst case O(n): All entries in same bucket (rare)
        """);

        System.out.println("\n2. Practical Performance Test:");
        System.out.println("──────────────────────────────");

        HashMap<Integer, String> perfMap = new HashMap<>();
        int iterations = 1000000;

        // PUT performance
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            perfMap.put(i, "Value_" + i);
        }
        long endTime = System.nanoTime();
        double putTime = (endTime - startTime) / 1_000_000.0;
        System.out.printf("✓ put() for %,d elements: %.2f ms\n", iterations, putTime);

        // GET performance
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            perfMap.get(i);
        }
        endTime = System.nanoTime();
        double getTime = (endTime - startTime) / 1_000_000.0;
        System.out.printf("✓ get() for %,d elements: %.2f ms\n", iterations, getTime);

        System.out.println("\n3. Space Complexity:");
        System.out.println("─────────────────────");
        System.out.println("""
            O(n) where n is number of entries
            
            HashMap uses extra space for:
            - Internal array (bucket array)
            - Node objects (key, value, hash, next pointer)
            - Load factor keeps array mostly empty (25% overhead)
            
            Memory = n entries + array overhead + collision chains
        """);

        System.out.println("\n4. When Worst Case Happens:");
        System.out.println("────────────────────────────");
        System.out.println("""
            Worst case O(n) happens when:
            1. Bad hash function → all keys hash to same bucket
            2. All entries in single chain
            3. Every get/put requires traversing entire chain
            
            This is why good hash function is critical!
            String, Integer, Long have well-implemented hashCode()
        """);
    }

    static void section6_ThreadSafety() {
        System.out.println("\n" + "▶".repeat(35));
        System.out.println("SECTION 6: THREAD SAFETY");
        System.out.println("▶".repeat(35));

        System.out.println("\n1. HashMap is NOT Thread-Safe:");
        System.out.println("──────────────────────────────");
        System.out.println("""
            ❌ HashMap
               - Not synchronized
               - Fast but dangerous in multi-threaded code
               - Can cause infinite loops during resize
               - Can lose data
            
            ✅ Hashtable (Legacy)
               - Fully synchronized (slow)
               - Avoids null keys/values
               - AVOID - use ConcurrentHashMap instead
            
            ✅ ConcurrentHashMap (Modern)
               - Segment-based locking (Java 7 and earlier)
               - Bucket-level locking (Java 8+)
               - Thread-safe without full lock
               - Better performance than Hashtable
        """);

        System.out.println("\n2. Synchronization Examples:");
        System.out.println("────────────────────────────");

        // Synchronized HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);

        Map<String, Integer> syncMap = Collections.synchronizedMap(map);
        System.out.println("✓ Created synchronized HashMap");
        System.out.println("  syncMap = Collections.synchronizedMap(HashMap)");
        System.out.println("✓ All operations are synchronized (but slower)");

        // ConcurrentHashMap
        System.out.println("\n✓ ConcurrentHashMap (BEST for multi-threading):");
        java.util.concurrent.ConcurrentHashMap<String, Integer> concurrMap =
                new java.util.concurrent.ConcurrentHashMap<>();
        concurrMap.put("X", 100);
        concurrMap.put("Y", 200);
        System.out.println("  - Bucket-level locking (not full lock)");
        System.out.println("  - Multiple threads can access different buckets");
        System.out.println("  - Better performance than Hashtable");

        System.out.println("\n3. Thread Safety Comparison:");
        System.out.println("────────────────────────────");
        System.out.println("""
            Use Case                      → Best Choice
            ──────────────────────────────────────────────
            Single thread                 → HashMap
            Multi-thread (simple)         → Collections.synchronizedMap()
            Multi-thread (recommended)    → ConcurrentHashMap ✅
            Multi-thread (legacy code)    → Hashtable (AVOID)
            
            Key Difference:
            HashMap: No synchronization (FAST but NOT SAFE)
            Hashtable: Full synchronization (SAFE but SLOW)
            ConcurrentHashMap: Partial lock (SAFE and FAST) ✅
        """);
    }
}

