ava:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"timed reference disposer" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@14e2789
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 66" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 65" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on com.intellij.util.concurrency.Semaphore$Sync@eef86e
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at com.intellij.util.concurrency.Semaphore.waitForUnsafe(Semaphore.java:80)
	at com.intellij.util.concurrency.Semaphore.waitFor(Semaphore.java:72)
	at com.intellij.openapi.application.impl.LaterInvocator.invokeAndWait(LaterInvocator.java:172)
	at com.intellij.openapi.application.impl.ApplicationImpl.invokeAndWait(ApplicationImpl.java:724)
	at com.intellij.openapi.project.DumbServiceImpl.a(DumbServiceImpl.java:528)
	at com.intellij.openapi.project.DumbServiceImpl.a(DumbServiceImpl.java:493)
	at com.intellij.openapi.project.DumbServiceImpl.access$1400(DumbServiceImpl.java:52)
	at com.intellij.openapi.project.DumbServiceImpl$8.run(DumbServiceImpl.java:430)
	at com.intellij.openapi.progress.impl.CoreProgressManager$TaskRunnable.run(CoreProgressManager.java:563)
	at com.intellij.openapi.progress.impl.CoreProgressManager$2.run(CoreProgressManager.java:142)
	at com.intellij.openapi.progress.impl.CoreProgressManager.a(CoreProgressManager.java:446)
	at com.intellij.openapi.progress.impl.CoreProgressManager.executeProcessUnderProgress(CoreProgressManager.java:392)
	at com.intellij.openapi.progress.impl.ProgressManagerImpl.executeProcessUnderProgress(ProgressManagerImpl.java:54)
	at com.intellij.openapi.progress.impl.CoreProgressManager.runProcess(CoreProgressManager.java:127)
	at com.intellij.openapi.progress.impl.ProgressManagerImpl$1.run(ProgressManagerImpl.java:126)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 64" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 63" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 62" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 61" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 60" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 59" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 58" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"threadDeathWatcher-2-1" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING

	at java.lang.Thread.sleep(Native Method)
	at io.netty.util.ThreadDeathWatcher$Watcher.run(ThreadDeathWatcher.java:137)
	at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:137)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 57" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 56" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 55" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 54" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 53" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 48" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"RMI RenewClean-[localhost:9009]" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.lang.ref.ReferenceQueue$Lock@117a6fc
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	at sun.rmi.transport.DGCClient$EndpointEntry$RenewCleanThread.run(DGCClient.java:536)
	at java.lang.Thread.run(Thread.java:745)

"RMI Scheduler(0)" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@136017f
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"GC Daemon" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on sun.misc.GC$LatencyLock@1a2c033
	at java.lang.Object.wait(Native Method)
	at sun.misc.GC$Daemon.run(GC.java:117)

"RMI Reaper" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.lang.ref.ReferenceQueue$Lock@1dcbb2a
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at sun.rmi.transport.ObjectTable$Reaper.run(ObjectTable.java:351)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 15" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING

	at java.lang.Thread.sleep(Native Method)
	at com.intellij.util.TimeoutUtil.sleep(TimeoutUtil.java:58)
	at com.intellij.util.io.BaseDataReader.doRun(BaseDataReader.java:114)
	at com.intellij.util.io.BaseDataReader$1.run(BaseDataReader.java:45)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 13" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING

	at java.lang.Thread.sleep(Native Method)
	at com.intellij.util.TimeoutUtil.sleep(TimeoutUtil.java:58)
	at com.intellij.util.io.BaseDataReader.doRun(BaseDataReader.java:114)
	at com.intellij.util.io.BaseDataReader$1.run(BaseDataReader.java:45)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"Change List Updater" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@1e379e6
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1081)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 7" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.util.concurrent.FutureTask@1b107c0
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.FutureTask.awaitDone(FutureTask.java:429)
	at java.util.concurrent.FutureTask.get(FutureTask.java:191)
	at org.jetbrains.idea.maven.utils.MavenUtil$9.waitFor(MavenUtil.java:487)
	at org.jetbrains.idea.maven.utils.MavenUtil$10$1.run(MavenUtil.java:503)
	at com.intellij.openapi.progress.impl.CoreProgressManager$TaskRunnable.run(CoreProgressManager.java:563)
	at com.intellij.openapi.progress.impl.CoreProgressManager$2.run(CoreProgressManager.java:142)
	at com.intellij.openapi.progress.impl.CoreProgressManager.a(CoreProgressManager.java:446)
	at com.intellij.openapi.progress.impl.CoreProgressManager.executeProcessUnderProgress(CoreProgressManager.java:392)
	at com.intellij.openapi.progress.impl.ProgressManagerImpl.executeProcessUnderProgress(ProgressManagerImpl.java:54)
	at com.intellij.openapi.progress.impl.CoreProgressManager.runProcess(CoreProgressManager.java:127)
	at com.intellij.openapi.progress.impl.ProgressManagerImpl$1.run(ProgressManagerImpl.java:126)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"Alarm pool(shared)" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@6659df
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"Document commit thread" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on com.intellij.util.containers.Queue@1a97efd
	at java.lang.Object.wait(Native Method)
	at com.intellij.psi.impl.DocumentCommitThread.c(DocumentCommitThread.java:322)
	at com.intellij.psi.impl.DocumentCommitThread.run(DocumentCommitThread.java:298)
	at java.lang.Thread.run(Thread.java:745)

"TimerQueue" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@18311fd
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.DelayQueue.take(DelayQueue.java:223)
	at javax.swing.TimerQueue.run(TimerQueue.java:171)
	at java.lang.Thread.run(Thread.java:745)

"Animations" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@26110e
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"FocusManager timer" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.util.TaskQueue@1b2e57c
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	at java.util.TimerThread.run(Timer.java:505)

"Shared SimpleTimer" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.TaskQueue@18d7292
	at java.lang.Object.wait(Native Method)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	at java.util.TimerThread.run(Timer.java:505)

"FS Synchronizer" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@18a47bd
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"Flushing thread" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@11dd735
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"Periodic tasks thread" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@1f22166
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"AWT-Shutdown" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.lang.Object@a01008
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at sun.awt.AWTAutoShutdown.run(AWTAutoShutdown.java:295)
	at java.lang.Thread.run(Thread.java:745)

"Java2D Disposer" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.lang.ref.ReferenceQueue$Lock@1220f0e
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at sun.java2d.Disposer.run(Disposer.java:148)
	at java.lang.Thread.run(Thread.java:745)

"Finalizer" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.lang.ref.ReferenceQueue$Lock@1d5e0
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

"Reference Handler" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: WAITING
 on java.lang.ref.Reference$Lock@f62cd7
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:157)

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     p.call(this);
      return this;
    },
    previousStep: function() {
      _previousStep.call(this);
      return this;
    },
    exit: function() {
      _exitIntro.call(this, this._targetElement);
    },
    refresh: function() {
      _setHelperLayerPosition.call(this, document.querySelector('.introjs-helperLayer'));
      return this;
    },
    onbeforechange: function(providedCallback) {
      if (typeof (providedCallback) === 'function') {
        this._introBeforeChangeCallback = providedCallback;
      } else {
        throw new Error('Provided callback for onbeforechange was not a function');
      }
      return this;
    },
    onchange: function(providedCallback) {
      if (typeof (providedCallback) === 'function') {
        this._introChangeCallback = providedCallback;
      } else {
        throw new Error('Provided callback for onchange was not a function.');
      }
      return this;
    },
    onafterchange: function(providedCallback) {
      if (typeof (providedCallback) === 'function') {
        this._introAfterChangeCallback = providedCallback;
      } else {
        throw new Error('Provided callback for onafterchange was not a function');
      }
      return this;
    },
    oncomplete: function(providedCallback) {
      if (typeof (providedCallback) === 'function') {
        this._introCompleteCallback = providedCallback;
      } else {
        throw new Error('Provided callback for oncomplete was not a function.');
      }
      return this;
    },
    onexit: function(providedCallback) {
      if (typeof (providedCallback) === 'function') {
        this._introExitCallback = providedCallback;
      } else {
        throw new Error('Provided callback for onexit was not a function.');
      }
      return this;
    }
  };

  exports.introJs = introJs;
  return introJs;
}));
