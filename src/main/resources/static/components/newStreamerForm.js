import {postFormData} from "../util/ajax.js"
import {printFirstPage} from "../pages/mainPage.js";
import {getTextInput} from "./textInput.js";

export function renderStreamerForm(){
    const div = document.createElement('div')
    const formElem = document.createElement('form')
    formElem.id = 'formElem'
    formElem.onsubmit = formHandler();
    const h3 = document.createElement('h3')
    h3.innerText = "Добавить нового стримера:"


    const pseudonym = getTextInput('pseudonym', 'Псевдоним: ')
    formElem.append(pseudonym)
    const firstname = getTextInput('firstname', 'Имя: ')
    formElem.append(firstname)
    const lastname = getTextInput('lastname', 'Фамилия: ')
    formElem.append(lastname)
    const pictureInput = getPictureInput('picture', 'Картинка: ')
    formElem.append(pictureInput)
    const submit = document.createElement('input')
    submit.type = 'submit'
    submit.value = 'Добавить'
    formElem.append(submit)

    div.append(document.createElement('br'))
    div.append(h3)
    div.append(formElem)
    return div
}

function getPictureInput(name, labelInput){
    const label = document.createElement('label')
    label.innerText = labelInput
    const fileInput = document.createElement('input')
    fileInput.type = 'file'
    fileInput.accept = 'image/*'
    fileInput.name = name
    fileInput.id = name
    label.append(fileInput)
    label.append(document.createElement('br'))
    return label
}

function formHandler() {
    return async (e) => {
        e.preventDefault();
        let data = new FormData()
        let streamer = {
            pseudonym: formElem.pseudonym.value,
            firstname: formElem.firstname.value,
            lastname: formElem.lastname.value,
        }
        data.append('new_streamer', new Blob([JSON.stringify(streamer)],
            {type: 'application/json'}
        ))
        data.append('picture', picture.files[0], picture.files[0].name)
        await postFormData(data, 'streamer')
        await printFirstPage()
    };
}