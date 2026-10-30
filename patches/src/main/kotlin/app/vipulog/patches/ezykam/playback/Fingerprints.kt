package app.vipulog.patches.ezykam.playback

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string

internal object Fingerprints {
    const val PLAYBACK_SPEED_HOOK_CLASS =
        "Lapp/vipulog/extension/ezykam/PlaybackSpeedHook;"

    const val PLAY_VIDEO_SPEED_CLASS =
        "Lcom/thingclips/smart/ipc/panel/api/playback/bean/PlayVideoSpeed;"

    const val PLAYBACK_PANEL_MODEL_CLASS =
        "Lcom/thingclips/smart/camera/panelimpl/playback/model/PlayBackPanelModel;"

    const val PLAYBACK_SPEED_REQUEST_CLASS =
        "Lcom/thingclips/smart/camera/panelimpl/playback/model/PlayBackPanelModel\$9;"

    const val PLAYBACK_SPEED_REQUEST_CALLBACK_CLASS =
        "Lcom/thingclips/smart/camera/panelimpl/playback/model/PlayBackPanelModel\$9\$1;"

    const val PLAYBACK_SPEED_ASSIST_CLASS =
        "Lcom/thingclips/smart/ipc/camera/panel/ui/playback/assist/PlaybackSpeedAssist;"

    const val PLAYBACK_SPEED_LISTENER_CLASS =
        "Lcom/thingclips/smart/ipc/camera/panel/ui/playback/assist/PlaybackSpeedAssist\$PlaybackSpeedListener;"

    const val PLAYBACK_PRESENTER_CLASS =
        "Lcom/thingclips/smart/ipc/panel/api/playback/contract/IPlayBackPresenter;"

    const val CAMERA_PLAYBACK_PANEL_ACTIVITY_CLASS =
        "Lcom/thingclips/smart/ipc/camera/panel/ui/playback/CameraPlayBackPanelActivity;"

    const val LANDSCAPE_PLAYBACK_PANEL_ACTIVITY_CLASS =
        "Lcom/thingclips/smart/ipc/camera/panel/ui/playback/CpCameraPlayBackLandPanelActivity;"

    const val CAMERA_PLAYBACK_FRAGMENT_CLASS =
        "Lcom/thingclips/smart/ipc/camera/panel/ui/playback/fragment/CameraPlayBackFragment;"

    const val TEXT_VIEW_CLASS =
        "Landroid/widget/TextView;"

    /**
     * Bitmask flag in Tuya Camera SDK indicating 4x fast-forward speed capability.
     */
    const val CAPABILITY_SPEED_4X_BITMASK = 0x400

    /**
     * Fingerprint for `PlayBackPanelModel.v0()`, which computes the supported playback speed
     * list from stored device capabilities.
     */
    val PlaybackModelSupportedSpeedsFingerprint = Fingerprint(
        definingClass = PLAYBACK_PANEL_MODEL_CLASS,
        name = "v0",
        returnType = "Ljava/util/List;",
        filters = listOf(string(" getSupportSpeedList localStorage=")),
    )

    /**
     * Fingerprint for `PlaybackSpeedAssist.a(String)`, which processes user selection from the
     * speed selection dialog.
     */
    val PlaybackSpeedSelectFingerprint = Fingerprint(
        definingClass = PLAYBACK_SPEED_ASSIST_CLASS,
        name = "a",
        returnType = "V",
        parameters = listOf("Ljava/lang/String;"),
    )

    /**
     * Fingerprint for `PlayBackPanelModel$9$1.onFailure(int, int, int)`, the async failure
     * callback invoked when the camera SDK does not acknowledge unadvertised speed capabilities.
     */
    val PlaybackSpeedRequestFailureFingerprint = Fingerprint(
        definingClass = PLAYBACK_SPEED_REQUEST_CALLBACK_CLASS,
        name = "onFailure",
        returnType = "V",
        parameters = listOf("I", "I", "I"),
    )

    /**
     * Fingerprint for portrait panel activity speed change events.
     */
    val PanelSpeedIndicatorFingerprint = Fingerprint(
        definingClass = CAMERA_PLAYBACK_PANEL_ACTIVITY_CLASS,
        name = "onPlayBackSpeed",
        returnType = "V",
        parameters = listOf(PLAY_VIDEO_SPEED_CLASS),
    )

    /**
     * Fingerprint for landscape panel activity speed change events.
     */
    val LandscapeSpeedIndicatorFingerprint = Fingerprint(
        definingClass = LANDSCAPE_PLAYBACK_PANEL_ACTIVITY_CLASS,
        name = "onPlayBackSpeed",
        returnType = "V",
        parameters = listOf(PLAY_VIDEO_SPEED_CLASS),
    )

    /**
     * Fingerprint for playback fragment speed change events.
     */
    val FragmentSpeedIndicatorFingerprint = Fingerprint(
        definingClass = CAMERA_PLAYBACK_FRAGMENT_CLASS,
        name = "onPlayBackSpeed",
        returnType = "V",
        parameters = listOf(PLAY_VIDEO_SPEED_CLASS),
    )
}
