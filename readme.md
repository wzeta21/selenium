user: bootcamp@mojix44.com
pwd: 12345

click Login -->  //img[contains(@src,'pagelogin')]
email txtbox ---> ctl00_MainContent_LoginControl1_TextBoxEmail
pwd txtbox ---> ctl00_MainContent_LoginControl1_TextBoxPassword
login button ---> ctl00_MainContent_LoginControl1_ButtonLogin
// verificar inicie sesion  ---->  logout option ---> ctl00_HeaderTopControl1_LinkButtonLogout

add new project button --> //td[text()='Add New Project']
project name txtbox ---> NewProjNameInput
add button ---> NewProjNameButton



// verificar la creacion  ---> //td[text()='Eynar'] --> SI EXISTE

click en el mennu desplegable ---> //div[contains(@style,'block')]/img
click edit option ---> //ul[@id="projectContextMenu"]//a[text()='Edit']
edit textbox --> //td/div/input[@id='ItemEditTextbox']
save button ---> //td/div/img[@id='ItemEditSubmit']

// verification update  ---> //td[text()='EynarUPDATE']  --> SI EXISTE

click en el mennu desplegable ---> //div[contains(@style,'block')]/img
click delete option ---> ProjShareMenuDel
click ok alert --> manejo de alertas selenium

// verification update  ---> //td[text()='EynarUPDATE'] ---> NO EXISTA

