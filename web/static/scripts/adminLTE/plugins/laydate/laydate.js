redInputStream.java:246)
	at java.io.BufferedInputStream.read(BufferedInputStream.java:265)
	at java.io.DataInputStream.readByte(DataInputStream.java:265)
	at sun.rmi.transport.StreamRemoteCall.executeCall(StreamRemoteCall.java:215)
	at sun.rmi.server.UnicastRef.invoke(UnicastRef.java:162)
	at java.rmi.server.RemoteObjectInvocationHandler.invokeRemoteMethod(RemoteObjectInvocationHandler.java:217)
	at java.rmi.server.RemoteObjectInvocationHandler.invoke(RemoteObjectInvocationHandler.java:171)
	at com.sun.proxy.$Proxy130.resolveProject(Unknown Source)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.execution.rmi.RemoteUtil.invokeRemote(RemoteUtil.java:124)
	at com.intellij.execution.rmi.RemoteUtil.access$100(RemoteUtil.java:36)
	at com.intellij.execution.rmi.RemoteUtil$2$1$1.compute(RemoteUtil.java:105)
	at com.intellij.execution.rmi.RemoteUtil.executeWithClassLoader(RemoteUtil.java:181)
	at com.intellij.execution.rmi.RemoteUtil$2$1.invoke(RemoteUtil.java:102)
	at com.sun.proxy.$Proxy130.resolveProject(Unknown Source)
	at org.jetbrains.idea.maven.server.MavenEmbedderWrapper$5.execute(MavenEmbedderWrapper.java:116)
	at org.jetbrains.idea.maven.server.MavenEmbedderWrapper$5.execute(MavenEmbedderWrapper.java:113)
	at org.jetbrains.idea.maven.server.RemoteObjectWrapper.perform(RemoteObjectWrapper.java:89)
	at org.jetbrains.idea.maven.server.MavenEmbedderWrapper.resolveProject(MavenEmbedderWrapper.java:113)
	at org.jetbrains.idea.maven.project.MavenProjectReader.resolveProject(MavenProjectReader.java:463)
	at org.jetbrains.idea.maven.project.MavenProject.resolve(MavenProject.java:637)
	at org.jetbrains.idea.maven.project.MavenProjectsTree.resolve(MavenProjectsTree.java:1258)
	at org.jetbrains.idea.maven.project.MavenProjectsProcessorResolvingTask.perform(MavenProjectsProcessorResolvingTask.java:42)
	at org.jetbrains.idea.maven.project.MavenProjectsProcessor.doProcessPendingTasks(MavenProjectsProcessor.java:134)
	at org.jetbrains.idea.maven.project.MavenProjectsProcessor.access$100(MavenProjectsProcessor.java:30)
	at org.jetbrains.idea.maven.project.MavenProjectsProcessor$2.run(MavenProjectsProcessor.java:109)
	at org.jetbrains.idea.maven.utils.MavenUtil$7.run(MavenUtil.java:464)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"Netty Builtin Server 2" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE
 (in native)
	at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
	at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(WindowsSelectorImpl.java:296)
	at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(WindowsSelectorImpl.java:278)
	at sun.nio.ch.WindowsSelectorImpl.doSelect(WindowsSelectorImpl.java:159)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at io.netty.channel.nio.NioEventLoop.select(NioEventLoop.java:621)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:309)
	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:742)
	at java.lang.Thread.run(Thread.java:745)

"Performance watcher" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE

	at sun.management.ThreadImpl.dumpThreads0(Native Method)
	at sun.management.ThreadImpl.dumpAllThreads(ThreadImpl.java:446)
	at com.intellij.diagnostic.ThreadDumper.dumpThreadsToFile(ThreadDumper.java:49)
	at com.intellij.diagnostic.PerformanceWatcher.dumpThreads(PerformanceWatcher.java:259)
	at com.intellij.diagnostic.PerformanceWatcher.f(PerformanceWatcher.java:213)
	at com.intellij.diagnostic.PerformanceWatcher.c(PerformanceWatcher.java:194)
	at com.intellij.diagnostic.PerformanceWatcher.access$100(PerformanceWatcher.java:44)
	at com.intellij.diagnostic.PerformanceWatcher$2.run(PerformanceWatcher.java:125)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 3" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE
 (in native)
	at java.lang.ProcessImpl.waitForInterruptibly(Native Method)
	at java.lang.ProcessImpl.waitFor(ProcessImpl.java:449)
	at com.intellij.execution.process.ProcessWaitFor$1.run(ProcessWaitFor.java:45)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 2" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE
 (in native)
	at java.io.FileInputStream.readBytes(Native Method)
	at java.io.FileInputStream.read(FileInputStream.java:255)
	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
	at java.io.InputStreamReader.read(InputStreamReader.java:184)
	at java.io.Reader.read(Reader.java:140)
	at com.intellij.util.io.BaseOutputReader.readAvailableBlocking(BaseOutputReader.java:96)
	at com.intellij.util.io.BaseOutputReader.readAvailable(BaseOutputReader.java:137)
	at com.intellij.util.io.BaseDataReader.doRun(BaseDataReader.java:108)
	at com.intellij.util.io.BaseDataReader$1.run(BaseDataReader.java:45)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"ApplicationImpl pooled thread 1" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE
 (in native)
	at java.io.FileInputStream.readBytes(Native Method)
	at java.io.FileInputStream.read(FileInputStream.java:255)
	at java.io.BufferedInputStream.read1(BufferedInputStream.java:284)
	at java.io.BufferedInputStream.read(BufferedInputStream.java:345)
	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
	at java.io.InputStreamReader.read(InputStreamReader.java:184)
	at java.io.Reader.read(Reader.java:140)
	at com.intellij.util.io.BaseOutputReader.readAvailableBlocking(BaseOutputReader.java:96)
	at com.intellij.util.io.BaseOutputReader.readAvailable(BaseOutputReader.java:137)
	at com.intellij.util.io.BaseDataReader.doRun(BaseDataReader.java:108)
	at com.intellij.util.io.BaseDataReader$1.run(BaseDataReader.java:45)
	at com.intellij.openapi.application.impl.ApplicationImpl$8.run(ApplicationImpl.java:365)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
	at org.jetbrains.ide.PooledThreadExecutor$1$1.run(PooledThreadExecutor.java:55)

"Netty Builtin Server 1" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE
 (in native)
	at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
	at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(WindowsSelectorImpl.java:296)
	at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(WindowsSelectorImpl.java:278)
	at sun.nio.ch.WindowsSelectorImpl.doSelect(WindowsSelectorImpl.java:159)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at io.netty.channel.nio.NioEventLoop.select(NioEventLoop.java:621)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:309)
	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:742)
	at java.lang.Thread.run(Thread.java:745)

"AWT-Windows" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE
 (in native)
	at sun.awt.windows.WToolkit.eventLoop(Native Method)
	at sun.awt.windows.WToolkit.run(WToolkit.java:306)
	at java.lang.Thread.run(Thread.java:745)

"Attach Listener" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE


"Signal Dispatcher" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE


"main" prio=0 tid=0x0 nid=0x0 runnable
     java.lang.Thread.State: RUNNABLE


"JobScheduler FJ pool 2/4" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on jsr166e.ForkJoinPool@19aa44
	at sun.misc.Unsafe.park(Native Method)
	at jsr166e.ForkJoinPool.awaitWork(ForkJoinPool.java:1756)
	at jsr166e.ForkJoinPool.scan(ForkJoinPool.java:1694)
	at jsr166e.ForkJoinPool.runWorker(ForkJoinPool.java:1642)
	at jsr166e.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:108)

"RMI TCP Connection(idle)" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@4bd0f0
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 83" prio=0 tid=0x0 nid=0x0 waiting on condition
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

"ApplicationImpl pooled thread 82" prio=0 tid=0x0 nid=0x0 waiting on condition
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

"RMI RenewClean-[127.0.0.1:11002]" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.lang.ref.ReferenceQueue$Lock@1256174
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	at sun.rmi.transport.DGCClient$EndpointEntry$RenewCleanThread.run(DGCClient.java:536)
	at java.lang.Thread.run(Thread.java:745)

"ApplicationImpl pooled thread 81" prio=0 tid=0x0 nid=0x0 waiting on condition
     java.lang.Thread.State: TIMED_WAITING
 on java.util.concurrent.SynchronousQueue$TransferStack@8fef47
	at sun.misc.Unsafe.park(Native Method)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.r