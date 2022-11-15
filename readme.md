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


click en textArea --> id: NewItemContentInput

click en el boton --> id: NewItemAddButton

ItemContentDiv UnderEditingItem
itemid:1107885

ItemEditDiv

textarea id: ItemEditTextbox

<textarea id="ItemEditTextbox" type="text" value="" class="InputTextEdit InputTextEditItem" autocomplete="off" onkeydown="ItemList.ItemEditKeyDown(event, this);" onblur="ItemList.ItemLostFocus(this);" itemid="11079193" readonly="readonly" style="height: 15px; width: 579px;"></textarea>

//*[@id="ItemEditTextbox"]
/html/body/form/div[3]/table/tbody/tr[2]/td/div/div/table/tbody/tr/td[2]/div[1]/div[1]/div[4]/ul/li/div/table/tbody/tr/td[3]/div[5]/div/textarea

trl + f8 + \ . y lo pausas el navegador por si te sirve

https://yopmail.com/

mail: input: //input[@id="login"]
button row: //button[@title="Check Inbox @yopmail.com"]
mail label: //div[@class = "bname"]

button new mail: //button[@id="newmail"]
iframe: id:ifmail
to: //input[@id="msgto"]
subject: //input[@id="msgsubject"]
mesage: //div[@id="msgbody"]
sent btn: //button[@id="msgsend"]
botn refresh: id:refresh  


