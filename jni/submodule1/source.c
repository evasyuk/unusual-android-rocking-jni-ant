#include "submodule.h"
#include <jni.h>
#include <string.h>
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_jv_example_RockingJNI_FileDumper_dumpFile
  (JNIEnv *env, jobject obj, jstring full_file_path, jstring text_to_dump)
{
    const char *file_path = (*env)->GetStringUTFChars(env, full_file_path, 0);
    const char *text = (*env)->GetStringUTFChars(env, text_to_dump, 0);
    FILE* file = fopen(file_path,"a+");

    if (file != NULL)
    {
        fputs(text, file);
        fflush(file);
        fclose(file);
    }

    (*env)->ReleaseStringUTFChars(env, full_file_path, file_path);
    (*env)->ReleaseStringUTFChars(env, text_to_dump, text);
}