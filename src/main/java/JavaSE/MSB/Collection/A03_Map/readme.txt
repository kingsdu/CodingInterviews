总结：
1：对于map/set的选择使用
HashMap
TreeMap
LinkedHashMap

Hashtable
Collections.sychronizedXXX

ConcurrentHashMap  无序，支持并发
ConcurrentSkipListMap 有序，支持并发
没有CocurrentTreeMap，是因为实现太复杂了，所以就有了ConcurrentSkipListMap(跳表结构)


2：队列
ArrayList
LinkedList
Collections.synchronizedXXX
CopyOnWriteList
Queue
	CocurrentLinkedQueue //concurrentArrayQueue
	BlockingQueue
		LinkedBQ
		ArrayBQ
		TransferQueue
		SynchronusQueue
	DelayQueue执行定时任务

