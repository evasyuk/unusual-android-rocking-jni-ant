
LOCAL_PATH:=$(shell pwd)#                                    #1

#////////////////////////////////////////////////////////////////////
#// SUB-MODULE-1
SM_DIR := $(LOCAL_PATH)/jni/submodule1#                      #2

include $(CLEAR_VARS)#                                       #3
LOCAL_MODULE:= echo#                                         #4
LOCAL_C_INCLUDES := $(SM_DIR)/include#                       #5
LOCAL_SRC_FILES:= $(SM_DIR)/source.c#                        #6
LOCAL_LDLIBS := -landroid -llog -latomic#                    #7

# DEBUG
#$(info $(LOCAL_PATH))
#$(info $(SM_DIR))
#$(info $(LOCAL_MODULE))
#$(info $(LOCAL_C_INCLUDES))
#$(info $(LOCAL_SRC_FILES))
#$(info $(LOCAL_LDLIBS))

include $(BUILD_SHARED_LIBRARY)#                             #8
#// SUB-MODULE-1
#////////////////////////////////////////////////////////////////////

