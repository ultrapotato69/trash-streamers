export function getTextInput(name, labelText, size) {
    const label = document.createElement('label')
    label.innerText = labelText
    const textInput = document.createElement('input')
    textInput.type = 'text'
    if (size != undefined){
        textInput.size = size
    }

    textInput.name = name
    textInput.id = name
    label.append(textInput)
    label.append(document.createElement('br'))
    return label
}