package data

import AnchorsManager
import anchors
import block
import com.mvvm.lib.anchors.tast.lock.LockableAnchor
import debuggable
import graphics
import sons
import startUp
import taskFactory


class Datas {





    companion object {
        const val PROJECT_1 = "PROJECT_1"
        const val TASK_10 = "TASK_10"
        const val TASK_11 = "TASK_11"
        const val TASK_12 = "TASK_12"
        const val TASK_13 = "TASK_13"
        const val PROJECT_2 = "PROJECT_2"
        const val TASK_20 = "TASK_20"
        const val TASK_21 = "TASK_21"
        const val TASK_22 = "TASK_22"
        const val TASK_23 = "TASK_23"
        const val PROJECT_3 = "PROJECT_3"
        const val TASK_30 = "TASK_30"
        const val TASK_31 = "TASK_31"
        const val TASK_32 = "TASK_32"
        const val TASK_33 = "TASK_33"
        const val PROJECT_4 = "PROJECT_4"
        const val TASK_40 = "TASK_40"
        const val TASK_41 = "TASK_41"
        const val TASK_42 = "TASK_42"
        const val TASK_43 = "TASK_43"
        const val PROJECT_5 = "PROJECT_5"
        const val TASK_50 = "TASK_50"
        const val TASK_51 = "TASK_51"
        const val TASK_52 = "TASK_52"
        const val TASK_53 = "TASK_53"
        const val PROJECT_6 = "PROJECT_6"
        const val TASK_60 = "TASK_60"
        const val TASK_61 = "TASK_61"
        const val TASK_62 = "TASK_62"
        const val TASK_63 = "TASK_63"
        const val PROJECT_7 = "PROJECT_7"
        const val TASK_70 = "TASK_70"
        const val TASK_71 = "TASK_71"
        const val TASK_72 = "TASK_72"
        const val TASK_73 = "TASK_73"
        const val PROJECT_8 = "PROJECT_8"
        const val TASK_80 = "TASK_80"
        const val TASK_81 = "TASK_81"
        const val TASK_82 = "TASK_82"
        const val TASK_83 = "TASK_83"
        const val PROJECT_9 = "PROJECT_9"
        const val TASK_90 = "TASK_90"
        const val TASK_91 = "TASK_91"
        const val TASK_92 = "TASK_92"
        const val TASK_93 = "TASK_93"
        const val UITHREAD_TASK_A = "UITHREAD_TASK_A"
        const val UITHREAD_TASK_B = "UITHREAD_TASK_B"
        const val UITHREAD_TASK_C = "UITHREAD_TASK_C"
        const val ASYNC_TASK_1 = "ASYNC_TASK_1"
        const val ASYNC_TASK_2 = "ASYNC_TASK_2"
        const val ASYNC_TASK_3 = "ASYNC_TASK_3"
        const val ASYNC_TASK_4 = "ASYNC_TASK_4"
        const val ASYNC_TASK_5 = "ASYNC_TASK_5"
    }


    fun startFromApplicationOnMainProcessByDsl() {
        AnchorsManager.getInstance().debuggable{true}
            .taskFactory { TestTaskFactory() }
            .anchors {  arrayOf(TASK_93, "TASK_E", TASK_10)}
            .block("TASK_10000"){
            }
            .graphics {

                UITHREAD_TASK_A.sons(
                    TASK_10.sons(
                        TASK_11.sons(
                            TASK_12.sons(
                                TASK_13))),
                    TASK_20.sons(
                        TASK_21.sons(
                            TASK_22.sons(TASK_23))),
                    TASK_30.sons(
                        TASK_32.sons(
                            TASK_32.sons(
                                TASK_33))),
                    TASK_40.sons(
                        TASK_42.sons(
                            TASK_42.sons(
                                TASK_43))),
                    TASK_50.sons(
                        TASK_51,
                        TASK_52.sons(TASK_53)),
                    TASK_60.sons(
                        TASK_61,
                        TASK_62.sons(TASK_63)),
                    TASK_70.sons(
                        TASK_71,
                        TASK_72.sons(TASK_73)),
                    TASK_80.sons(
                        TASK_81,
                        TASK_82.sons(TASK_83)),
                    TASK_90.sons(
                        TASK_91,
                        TASK_92.sons(TASK_93)),
                    UITHREAD_TASK_B,
                    UITHREAD_TASK_C
                )
                arrayOf(UITHREAD_TASK_A)

            }.startUp()
    }


    fun startFromApplicationOnPrivateProcess()
    {
        AnchorsManager.getInstance().
        debuggable{true}.
        taskFactory { TestTaskFactory()  }
            .anchors { arrayOf(TASK_82) }
            .graphics {

                UITHREAD_TASK_A.sons(
                    TASK_80.sons(
                        TASK_81,
                        TASK_82.sons(TASK_83)),
                    UITHREAD_TASK_B)
                arrayOf(UITHREAD_TASK_A)

            }.startUp()

    }


    fun startForTestLockableAnchorByDsl(listener: (lockableAnchor: LockableAnchor) -> Unit): LockableAnchor? {
        val manager = AnchorsManager.getInstance()
            .debuggable { true }
            .taskFactory { TestTaskFactory() }
            .block(TASK_10) {
                listener.invoke(it)
            }
            .graphics {
                arrayOf(TASK_10.sons(TASK_11.sons(TASK_12.sons(TASK_13))))
            }
            .startUp()
        return manager.getLockableAnchors()[TASK_10]
        //等价于
//        val factory = TestTaskFactory()
//        val manager = getInstance()
//                .debuggable { true }
//                .taskFactory { factory }
//                .graphics {
//                    arrayOf(TASK_10.sons(TASK_11.sons(TASK_12.sons(TASK_13))))
//                };
//        val lockableAnchor = manager.requestBlockWhenFinish(factory.getTask(TASK_10))
//        lockableAnchor.setLockListener(object : LockableAnchor.LockListener {
//            override fun lockUp() {
//                listener.invoke(lockableAnchor)
//            }
//        })
//        manager.startUp()
//        return lockableAnchor
    }


    fun startForLinkTwoByDsl() {
        val manager = AnchorsManager.getInstance()
            .debuggable { true }
            .taskFactory { TestTaskFactory() }
            .graphics {
                arrayOf(UITHREAD_TASK_A.sons(TASK_20.sons(TASK_21.sons(TASK_22.sons(TASK_23)))))
            }
            .startUp()
    }

    fun startForLinkOneByDsl(runnable: Runnable) {
        val  factory = TestTaskFactory()
        val end = factory.getTask(TASK_13)
        end.addTaskListener{
            onRelease {
                runnable.run()
            }
        }

        val manager = AnchorsManager.getInstance()
            .taskFactory { factory }
            .graphics {
                arrayOf(UITHREAD_TASK_A.sons(TASK_10.sons(TASK_11.sons(TASK_12.sons(TASK_13)))))
            }
            .startUp()

    }



}