package com.github.burkclik.asplugin.actions.modulebased

import com.github.burkclik.asplugin.actions.base.ModuleBasedGradleAction

class ModuleBasedDetektCheckAction : ModuleBasedGradleAction() {

    override fun getActionName(): String = TASK_NAME

    companion object {
        const val TASK_NAME = "detekt"
    }

}