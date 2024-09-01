package vrenamer;

import java.awt.event.*;

public class idiomasEng implements idiomas {

  public String getMainRenamed() {
    return "renamed";    
  }
  public String getMainCopied() {
    return "copied";    
  }
  public String getMainChanged() {
    return "changed";    
  }
  public String getMainDone() {
    return "DONE";    
  }

  public String getCheckVersion() {
    return "Checking version";    
  }
  public String getVersionAvailable() {
    return "New version available: ";    
  }
  public String getVersion() {
    return "New version";    
  }
  public String getVersionDownload() {
    return "Download";    
  }
  public String getVersionDismiss() {
    return "Decline";    
  }
  public String getVersionNever() {
    return "Don't ask me again";    
  }

  public String getMenuNew() {
    return "New";
  }
  public String getMenuFile() {
    return "File";
  }
  public String getMenuEdit() {
    return "Edit";
  }  

  public String getMenuOpen() {
    return "Open file";
  }
  public String getMenuOpenRecent() {
    return "Open recent";
  }
  public String getMenuSave() {
    return "Save";
  }
  public String getMenuSaveAs() {
    return "Save as";
  }

  public String getMenuPrefs() {
    return "View";
  } 
  public String getMenuIdioma() {
    return "Choose Language:";
  }
  public String getMenuSpanish() {
    return "Spanish";
  }
  public String getMenuEnglish() {
    return "US English";
  }
  public String getMenuOptions() {
    return "Options";
  }

  public String getMenuSesion() {
    return "When starting vRenamer:";
  }
  public String getMenuSesionClean() {
    return "Create a clean session";
  }
  public String getMenuSesionLast() {
    return "Restore last session";
  }
  public String getMenuAuto() {
    return "Automatic preview";
  }

  public String getMenuDate() {
    return "Date";
  }

  public String getMenuDayMonth() {
    return "Month format";
  }
  public String getMenuDayOne() {
    return "01, 02, 03...";
  }
  public String getMenuDayTwo() {
    return "Jan, Feb, Mar...";
  }
  public String getMenuDayThree() {
    return "January, February, March...";
  }

  public String getMenPickDate() {
    return "Date picker";
  }
  public String getMenPickModified() {
    return "File last modified";
  }
  public String getMenPickCreation() {
    return "File creation";
  }
  public String getMenPickAccessed() {
    return "File last accessed";
  }
  public String getMenPickManual() {
    return "Manually choose from calendar";
  }
  public String getMenPickStamp() {
    return "Date stamp";
  }

  public String getCalendarReload() {
    return "Reload calendar";
  }

  public String getMenuRenaming() {
    return "Renaming";
  }
  public String getMenuRenamingLbl() {
    return "When dropping a folder: ";
  }
  public String getMenuRenamingUno() {
    return "Just drop the folder";
  }
  public String getMenuRenamingDos() {
    return "Drop the folder contents";
  }
  public String getMenuTrash() {
    return "Define trash characters:";
  }

  public String getMenuEstructuraLbl() {
    return "When recursively copying: ";
  }
  public String getMenuEstructuraUno() {
    return "Just copy the files";
  }
  public String getMenuEstructuraDos() {
    return "Copy files along with folder structure";
  }

  public String getMenuCarpetaRecursivaLbl() {
    return "Recursive search mode: ";
  }
  public String getMenuCarpetaRecursivaUno() {
    return "Collect and add files";
  }
  public String getMenuCarpetaRecursivaDos() {
    return "Collect and add folders";
  }

  public String getMenuCopiarRenombradosLbl() {
    return "Copy Mode: ";
  }
  public String getMenuCopiarRenombradosUno() {
    return "Copy all selected files";
  }
  public String getMenuCopiarRenombradosDos() {
    return "Copy only files that will be renamed";
  }

  public String getMenuTituloCarpeta() {
    return "File & Folders Behaviour";
  }
  public String getMenuTituloNormaliza() {
    return "Normalize Savings";
  }

  public String getMenuHelp() {
    return "Help";
  }  
  public String getMenuPreview() {
    return "Preview";
  }  
  public String getMenuApply() {
    return "Apply";
  }  
  public String getMenuDefault() {
    return "Default Settings";
  }

  public String getSelectFile() {
    return "Rename files";
  }  
  public String getSelectExtension() {
    return "Rename extensions";
  }  
  public String getSelectWhole() {
    return "Rename whole name";
  }  

  public String getMenuLog() {
    return "Import log file";
  }  
  public String getMenuImport() {
    return "Input custom filenames";
  }  
  public String getMenuExit() {
    return "Exit";
  }  
  public String getMenuHidden() {
    return "Show hidden";
  }  
  public String getMenuDrop() {
    return "Drop Mode";
  }
  public String getMenuTipDrop() {
    return "Clean items";
  }
  public String getMenuSalirDrop() {
    return "Exit";
  }
  public String getTipMenuSalirDrop() {
    return "Exit Drop Mode";
  }

  public String getMenuUndo() {
    return "Undo";
  }  
  public String getMenuRedo() {
    return "Redo";
  } 
  public String getMenuSelectAll() {
    return "Select all";
  }  
  public String getMenuInvSel() {
    return "Invert selection";
  }   
  public String getMenuSelFile() {
    return "Select files";
  }  
  public String getMenuSelFolder() {
    return "Select folders";
  }  
  public String getMenuAbout() {
    return "About vRenamer";
  }

/** 
 * Underlined letters in menu
 */

  public int getMenuMaskOpen() {
    return KeyEvent.VK_O;
  }
  public int getMenuMaskSave() {
    return KeyEvent.VK_S;
  }
  public int getMenuMaskSaveAs() {
    return KeyEvent.VK_A;
  }

  public int getMenuMaskFile() {
    return KeyEvent.VK_F;
  }
  public int getMenuMaskHelp() {
    return KeyEvent.VK_H;
  }
  public int getMenuMaskExit() {
    return KeyEvent.VK_X;
  }
  public int getMenuMaskAbout() {
    return KeyEvent.VK_B;
  }
  public int getMenuMaskUndo() {
    return KeyEvent.VK_U;
  }
  public int getMenuMaskIdioma() {
    return KeyEvent.VK_C;
  }
  public int getMenuMaskSpanish() {
    return KeyEvent.VK_E;
  }
  public int getMenuMaskEnglish() {
    return KeyEvent.VK_I;
  }
  public int getMenuMaskSesion() {
    return KeyEvent.VK_S;
  }
  public int getMenuMaskSesionClean() {
    return KeyEvent.VK_C;
  }
  public int getMenuMaskSesionLast() {
    return KeyEvent.VK_L;
  }
  public int getMenuMaskLog() {
    return KeyEvent.VK_I;
  }
  public int getMenuMaskImport() {
    return KeyEvent.VK_P;
  }

  public int getMenuMaskSettings() {
    return KeyEvent.VK_V;
  }
  public int getMenuMaskSorting() {
    return KeyEvent.VK_O;
  }

  public int getMenuMaskByName() {
    return KeyEvent.VK_N;
  }
  public int getMenuMaskByDate() {
    return KeyEvent.VK_D;
  }
  public int getMenuMaskByPictureDate() {
    return KeyEvent.VK_P;
  }
  public int getMenuMaskBySize() {
    return KeyEvent.VK_I;
  }
  public int getMenuMaskByExtension() {
    return KeyEvent.VK_E;
  }
  public int getMenuMaskByNumber() {
    return KeyEvent.VK_U;
  }

/**
 *
 */

  public String getPath() {
    return "Path";
  }
  public String getFiltro() {
    return "Filter";
  }
  public String getExclude() {
    return "Exclude";
  }

  public String getTipReload() {
    return "Reload";
  }
  public String getTipClean() {
    return "Clean";
  }  
  public String getTipPreview() {
    return "Preview";
  }  
  public String getTipApply() {
    return "Apply";
  }
  public String getTipCase() {
    return "Case sensitive";
  }
  public String getTipExclude() {
    return "Search files not containing the expression";
  }
  public String getTipRecursive() {
    return "Search in subfolders";
  }

  public String getTitleOriginals() {
    return "Current files";
  }
  public String getTitlePreviews() {
    return "Preview";
  }

  public String getCopyFolder() {
    return "Copy to folder";
  }
  public String getMoveFolder() {
    return "Move to folder";
  }
  public String getExtension() {
    return "Extension";
  }
  public String getSeparator() {
    return "Separator";
  }

  public String getTabBasic() {
    return "Main tasks";
  }
  public String getTabOther() {
    return "Common renamings";
  }
  public String getTabMp3() {
    return "Tag audio file";
  }

  public String getTitleRename() {
    return "Rename";
  }
  public String getTitleRemove() {
    return "Insert/remove";
  }
  public String getTitleMp3() {
    return "Write audio file";
  }

  public String getTagTrack() {
    return "Track";
  }
  public String getTagTitle() {
    return "Title";
  }
  public String getTagArtist() {
    return "Artist";
  }
  public String getTagAlbum() {
    return "Album";
  }
  public String getTagYear() {
    return "Year";
  }
  public String getTagGenre() {
    return "Genre";
  }

  public String getBtnGet() {
    return "Get";
  }
  public String getBtnClean() {
    return "Clean";
  }
  public String getBtnSet() {
    return "Set";
  }
  public String getBtnIncrease() {
    return "Increase";
  }

  public String getOpCombina() {
    return "Combine";
  }
  public String getOpInserta() {
    return "Insert";
  }
  public String getOpElimina() {
    return "Remove";
  }
  public String getOpAcentos() {
    return "Remove accents";
  }
  public String getOpReemplaza() {
    return "Replace";
  }
  public String getOpNormaliza() {
    return "Normalize";
  }
  public String getOpBasura() {
    return "Remove trash characters";
  }
  public String getOpCapitaliza() {
    return "Change case";
  }
  public String getOpEspacios() {
    return "Fix repeated spaces";
  }
  public String getOpTrim() {
    return "Trim file names";
  }

  public String getOpNumeros() {
    return "Numbers";
  }  
  public String getOpNormaCeros() {
    return "Arrange";
  }
  public String getOpRenumber() {
    return "Renumber";
  }
  public String getNormaPosition() {
    return "Position";
  }
  public String getNormaCeros() {
    return "Zeros";
  }

  public String getOpAleatorio() {
    return "Random name";
  }
  public String getOpAtributos() {
    return "File attributes";
  }

  public String getExecute() {
    return "Executable";
  }
  public String getReadable() {
    return "Readable";
  }
  public String getWritable() {
    return "Writable";
  }
  public String getHidden() {
    return "Hidden";
  }

  public String getReadOnly() {
    return "Read only";
  }

  public String getActivated() {
    return "Enabled";
  }
  public String getDeactivated() {
    return "Disabled";
  }
  public String getApplyAll() {
    return "Apply all";
  }
  public String getApplySelected() {
    return "Apply selected";
  }

  public String getMainIn() {
    return "in";
  }
  public String getMainRight() {
    return "From right";
  }
  public String getMainPosition() {
    return "from index";
  }
  public String getMainThrough() {
    return "through";
  } 

  public String getLengthOne() {
    return "with length";
  }
  public String getLengthTwo() {
    return "Original length";
  }
  public String getWith() {
    return "with";
  }

  public String getCaseUp() {
    return "Uppercase";
  }
  public String getCaseLow() {
    return "Lowercase";
  }
  public String getCaseFirst() {
    return "First in uppercase";
  }
  public String getCaseAll() {
    return "First of each word in uppercase";
  }
  public String getCaseSymbol() {
    return "First after any of these";
  }

  public String getComboText() {
    return "Text";
  }
  public String getComboNumber() {
    return "Sequence";
  }
  public String getComboFile() {
    return "File name";
  }
  public String getComboFolder() {
    return "Folder name";
  }
  public String getComboDate() {
    return "Date";
  }
  public String getComboDatePicture() {
    return "Picture date";
  }
  public String getComboCamera() {
    return "Camera";
  }
  public String getComboMusic() {
    return "Music";
  }

  public String getSeqArab() {
    return "Numeral";
  }
  public String getSeqRoman() {
    return "Roman";
  }
  public String getSeqLetters() {
    return "Letters";
  }
  public String getSeqBinary() {
    return "Binary";
  }
  public String getSeqHex() {
    return "Hexadecimal";
  }
  public String getSeqOc() {
    return "Octal";
  }

  public String getSeqUpp() {
    return "Upper";
  }
  public String getSeqLow() {
    return "Lower";
  }

  public String getNumberLabel() {
    return "In ";
  }
  public String getNumberSkip() {
    return " Skip ";
  }
  public String getNumberOptionsUno() {
    return "Keep always";
  }
  public String getNumberOptionsDos() {
    return "Restart on each folder";
  }
  public String getNumberOptionsTres() {
    return "Restart on every name change";
  }
  public String getNumberOptionsCuatro() {
    return "Only if needed";
  }
  public String getNumberOptionsCinco() {
    return "Detect and resume";
  }

  public String getFileCut() {
    return "Split";
  }
  public String getFileFrom() {
    return "From";
  }
  public String getFileTo() {
    return "up to";
  }
  public String getFileSection() {
    return "Section";
  }
  public String getFileOnly() {
    return "Section only";
  }
  public String getFileEnd() {
    return "Up to the end of the text";
  }
  public String getFileBeginning() {
    return "Up to the beginning of the text";
  }

  public String getFileBetween() {
    return "Between";
  }
  public String getFileAnd() {
    return "and";
  }

  public String getFolderSame() {
    return "No changes";
  }
  public String getFolderUpper() {
    return "To uppercase";
  }
  public String getFolderLower() {
    return "To lowercase";
  }

  public String getDateOne() {
    return "DDMMYYYY";
  }
  public String getDateTwo() {
    return "DDMMYY";
  }
  public String getDateThree() {
    return "MMYYYY";
  }
  public String getDateFour() {
    return "MMYY";
  }
  public String getDateFive() {
    return "YYYYMMDD";
  }
  public String getDateSix() {
    return "YYMMDD";
  }
  public String getDateSeven() {
    return "YYYYMM";
  }
  public String getDateEight() {
    return "YYMM";
  }
  public String getDateNine() {
    return "MMDDYYYY";
  }
  public String getDateTen() {
    return "MMDDYY";
  }
  public String getDateEleven() {
    return "YYYY";
  }

  public String getCamMake() {
    return "Make";
  }
  public String getCamModel() {
    return "Model";
  }
  public String getCamWidth() {
    return "Width";
  }
  public String getCamHeight() {
    return "Height";
  }
  public String getCamAperture() {
    return "Aperture Value";
  }
  public String getCamExposure() {
    return "Exposure Time";
  }
  public String getCamExposureBias() {
    return "Exposure Bias Value";
  }
  public String getCamIso() {
    return "ISO Speed Ratings";
  }
  public String getCamBrightness() {
    return "Brigthness Value";
  }
  public String getCamFocal() {
    return "Focal length";
  }
  public String getCamColor() {
    return "Color Space";
  }

  public String getTipCut() {
    return "<html>Splits the selected files around matches of this entry.<br> If left empty, will take the whole text.<br> Can process regular expressions.<br><br>Some examples:<br><br><b>[0-9]+</b> Splits on a number (group of digits)<br><b>[0-9]</b> Splits on each digit separatedly<br><b>[a-zA-Z]+</b> Splits on every alfabetic string<br><b>[^abc]</b> Splits on every character except 'a', 'b' or 'c'<br><b>\\(.*\\)</b> Splits on the whole text between brackets (included)<br><b>_|-</b> Splits on characters '_' or '-'<br><b>[0-9]|M</b> Splits on each digit or on character 'M'</html>";


  }
  public String getTipSection() {
    return "<html>Excerpt from the split text that will be used to rename<br>Counting from the right if option 'Up to the beginning of the text' is selected</html>";
  }
  public String getTipReplace() {
    return "<html>Can process <b>regular expressions</b>.<br><br>Some examples:<br><br><b>[0-9]+</b> A number (group of digits)<br><b>[0-9]</b> A digit<br><b>[a-zA-Z]+</b> a through z or A through Z, inclusive (range)<br><b>[^abc]</b> Any character except a, b, or c (negation)<br><b>\\(.*\\)</b> Select all the text between brackets (included)<br><b>^casa</b> Select the word 'casa' if it's at the beginning<br><b>casa$</b> Select the word 'casa' if it's at the end<br><br><b>Capturing groups:</b><br><br>Patterns can be captured via round brackets to form regex groups.<br>Via the $ you can refer to a group. $1 is the first group, $2 the second, etc.<br><br>Example:<br><br><b>Filename:</b> Photo_001<br><b>Pattern:</b> ([a-zA-Z]+)(_)([0-9]+)<br><b>Reference:</b> $3-$1<br><b>Result:</b> 001-Photo</html>";
  }
  public String getTipFilter() {
    return "<html>Can process regular expressions.<br><br>Some examples:<br><br><b>.{20}</b> Search for files containing 20 or more characters<br><b>[0-9]</b> Search for files containing numbers<br><b>[_?-]</b> Search for files containing at least one of characters in the brackets<br><b>^casa</b> Search for files with the word casa at the begining<br><b>casa$</b> Search for files with the word casa at the end<br><b>.jpg$</b> Search for files with jpg extension</html>";
  }
  public String getTipCapture() {
    return "<html>Can process <b>regular expressions</b>.<br><br>Place here the reference to captured groups<br><br>$1 is the first group, $2 the second, etc.</html>";
  }

  public String getCopiaOk() {
    return "Ok";
  }
  public String getCopiaTitle() {
    return "Select folder";
  }

  public String getLicenseTitle() {
    return "License agreement";
  }

  public String getAboutTitle() {
    return "About";
  }
  public String getAboutLabel() {
    return "Version";
  }
  public String getAboutLicense() {
    return "License";
  }

  public String getWarningFile() {
    return "The file ";
  }
  public String getWarningExists() {
    return "Already exists";
  }
  public String getWarningWarning() {
    return "The target file already exists";
  }
  public String getWarningAction() {
    return "Please, choose an action";
  }
  public String getWarningSource() {
    return "Source file:";
  }
  public String getWarningTarget() {
    return "Target file:";
  }
  public String getWarningOverwrite() {
    return "Overwrite";
  }
  public String getWarningSkip() {
    return "Skip";
  }
  public String getWarningLabelAction() {
    return "Action";
  }
  public String getWarningAlways() {
    return "Always use this action";
  }


  public String getForbiddenWindows() {
    return "Forbidden copy operation in Windows";
  }

  public String getErrorLabel() {
    return "No access to ";
  }
  public String getCopyLabel() {
    return "Copy:";
  }
  public String getMoveLabel() {
    return "Move:";
  }

  public String getInfoFolder() {
    return "folders";
  }
  public String getInfoFile() {
    return "files";
  }
  public String getFilechanged() {
    return "changed";
  }

  public String getFiltroOn() {
    return "Filter on";
  }
  public String getError() {
    return "Error";
  }
  public String getErrors() {
    return "Errors";
  }

  public String getInfoLoading() {
    return "Loading";
  }

  public String getModoAll() {
    return "Replace all";
  }
  public String getModoFirst() {
    return "Replace first";
  }

  public String getOptionYes() {
    return "Yes";
  }
  public String getOptionYesAll() {
    return "Yes to all";
  }
  public String getOptionCancel() {
    return "Cancel";
  }

  public String getManualOrder() {
    return "Manual order";
  }
  public String getNameOrder() {
    return "Sort by name";
  }
  public String getLastOrder() {
    return "Sort by date";
  }
  public String getCameraDateOrder() {
    return "Sort by picture date";
  }
  public String getExtensionOrder() {
    return "Sort by extension";
  }
  public String getSizeOrder() {
    return "Sort by size";
  }
  public String getNumberOrder() {
    return "Sort by numbers intelligently";
  }

  public String getSorting() {
    return "Sorting";
  }

  public String getPopUp() {
    return "Up";
  }
  public String getPopDown() {
    return "Down";
  }
  public String getPopTop() {
    return "Top";
  }
  public String getPopBottom() {
    return "Bottom";
  }
  public String getNormal() {
    return "Normal order";
  }
  public String getReverse() {
    return "Reverse order";
  }

  public String getLogFile() {
    return "log file";
  }
  public String getChooseLogFile() {
    return "Choose log file";
  }
  public String getChooseDateFile() {
    return "Choose date log";
  }
  public String getLogCurrent() {
    return "Current files";
  }
  public String getLogRecover() {
    return "Files to recover";
  }

  public String getFilterImg() {
    return "-- Image";
  }
  public String getFilterAudio() {
    return "-- Audio";
  }
  public String getFilterVideo() {
    return "-- Video";
  }


  public String getName() {
    return "Name: ";
  }
  public String getLength() {
    return "Length: ";
  }
  public String getModified() {
    return "Modified: ";
  }

  public String getOpcionPreview() {
    return "Images preview";
  }
  public String getOpcionSolo() {
    return "Only in info panel";
  }
  public String getOpcionAmbos() {
    return "In both info panel and files view";
  }

  public String getBarMp3() {
    return "Retrieving audio file data";
  }
  public String getBarBrowse() {
    return "Browsing";
  }
  public String getBarMp3Write() {
    return "Writing audio file data";
  }
  public String getBarPreview() {
    return "Creating preview";
  }
  public String getBarApply() {
    return "Committing changes";
  }
  public String getBarSort() {
    return "Sorting files";
  }
  public String getDescription() {
    return "Easy-to-use full featured mass renamer";
  }

  public String getPanelText() {
    return "User List";
  }
  public String getTextHelp() {
    return "Write or drop custom filenames, one per line ";
  }
  public String getTextApply() {
    return "Apply to: ";
  }
  public String getTextFiles() {
    return "Files";
  }
  public String getTextFolders() {
    return "Folders";
  }
  public String getTextExtension() {
    return "Add original filenames extensions";
  }

  public String getUnoMove() {
    return "Move";
  }

  public String getInfoRenamed() {
    return "R = Renamed";
  }
  public String getInfoMoved() {
    return "M = Moved";
  }

  public String getDropHere() {
    return "Drag and Drop your files here";
  }
  public String getDropNot() {
    return "Or exit Drop Mode to browse files within the application";
  }

  public String getDropRepetidos() {
    return "Duplicated files or folders not allowed";
  }
  public String getDropMixtos() {
    return "Mixed files and folders not allowed";
  }

  public String getFromFile() {
    return "Get from filename";
  }
  public String getFromFolder() {
    return "From folder name";
  }
  public String getFromTag() {
    return "From current tag";
  }
  public String getFromLast() {
    return "From Last.fm";
  }

  public String getMp3Modify() {
    return "Modify";
  }

  public String getMp3Keep() {
    return "Keep Case";
  }
  public String getMp3Upper() {
    return "Uppercase";
  }
  public String getMp3Lower() {
    return "Lowercase";
  }
  public String getMp3First() {
    return "Only First";
  }
  public String getMp3Title() {
    return "Title Case";
  }

  public String getTagFor() {
    return "Write Tag for";
  }

  public String getCredits() {
    return "Credits";
  }


}
