package app.revanced.patches.youtube.layout.tabletminiplayer.fingerprints

import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.annotation.FuzzyPatternScanMethod
import app.revanced.patcher.fingerprint.method.annotation.MatchingMethod
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import app.revanced.patches.youtube.layout.tabletminiplayer.annotations.TabletMiniPlayerCompatibility
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

@Name("mini-player-dimensions-calculator-fingerprint")
@MatchingMethod(
    "Lkkr;", "pM"
)
@FuzzyPatternScanMethod(2) // TODO: Find a good threshold value
@TabletMiniPlayerCompatibility
@Version("0.0.1")
object MiniPlayerDimensionsCalculatorFingerprint : MethodFingerprint(
    "V",
    AccessFlags.PUBLIC or AccessFlags.FINAL,
    listOf("L"),
    listOf(
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.IGET_OBJECT,
        Opcode.IGET_OBJECT,
        Opcode.MUL_FLOAT,
        Opcode.INVOKE_INTERFACE,
        Opcode.IGET_BOOLEAN,
        Opcode.CONST_4,
        Opcode.IF_EQZ,
        Opcode.INVOKE_DIRECT,
        Opcode.MOVE_RESULT,
        Opcode.IF_NEZ,
        Opcode.FLOAT_TO_DOUBLE,
        Opcode.CONST_WIDE_HIGH16,
        Opcode.CMPL_DOUBLE,
    )
)