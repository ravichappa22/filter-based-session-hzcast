http://localhost:8050/filter_based_session_hzcast/hazelcast

1)transaction based cookie needed to unique key for every trasnaction
2)when setting the HZ key - we have to set the expiry of that key as session time out + buffer (we can make it double)
3)destry the key completly when user done with transaction or logout
4)eveyr new transaction new cookie key need to be geneated
