This is an implementation of Consistent Hashing, which is commonly used in distributed systems to decide which server (node) should handle a request.

Examples:

Load balancers
Distributed caches (Redis Cluster)
Databases (Cassandra, DynamoDB)
Distributed storage systems

The biggest advantage is that when a server is added or removed, only a small number of requests move to different servers, unlike normal hashing.
