/*
 * Copyright (C) 2010-2020, Danilo Pianini and contributors
 * listed in the main project's alchemist/build.gradle.kts file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */

package it.unibo.alchemist.boundary.jfx.events.mouse

import it.unibo.alchemist.boundary.jfx.events.generic.PersistentEventDispatcher
import javafx.scene.input.MouseEvent

/**
 * An event dispatcher in the context of mouse events.
 */
abstract class MouseEventDispatcher : PersistentEventDispatcher<MouseTriggerAction, MouseEvent>() {

    abstract override val listener: MouseActionListener
}