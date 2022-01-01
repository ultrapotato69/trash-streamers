function getYoutubeElement(youtubeId) {
    const youtubeVideo = document.createElement('iframe')
    youtubeVideo.id = "ytplayer"
    youtubeVideo.type = 'text/html'
    youtubeVideo.width = '640'
    youtubeVideo.height = '360'
    youtubeVideo.src = 'http://www.youtube.com/embed/' + youtubeId
    youtubeVideo.frameborder = 0
    youtubeVideo.allowfullscreen = true
    return youtubeVideo;
}

export function renderStreamer(objectStreamer) {
    const div = document.createElement('div')
    const pseudonym = document.createElement('b')
    pseudonym.innerText = objectStreamer.pseudonym
    div.append(pseudonym)
    const aka = document.createElement('span')
    aka.innerText = "aka"
    objectStreamer.otherPseudonyms.forEach(otherPseudonym => {
        div.append(" aka ")
        const other = document.createElement('b')
        other.innerText = otherPseudonym
        div.append(other)
    })
    const realInfo = document.createElement('div')
    const name = document.createElement('span')
    name.innerHTML = "Настоящее имя: " + objectStreamer.firstname + " " + objectStreamer.lastname
    realInfo.append(name)
    div.append(realInfo)

    const picture = getPicture(objectStreamer.pictureName)
    div.append(picture)
    const description = document.createElement('div')
    description.innerText = objectStreamer.description
    div.append(description)
    const youTubeVideoList = getYouTubeVideoList(objectStreamer.videos);
    div.append(youTubeVideoList)
    return div
}

function getYouTubeVideoList(videoArr){
    const div = document.createElement('div')
    if (videoArr != null && videoArr != undefined && videoArr.length > 0) {
        for (let i = 0; i < videoArr.length; i++) {
            const youtubeVideo = getYoutubeElement(videoArr[i].youtubeId);
            div.append(youtubeVideo)
        }
    }
    return div
}

function getPicture(pictureName) {
    const p = document.createElement('p')
    const img = document.createElement('img')
    img.src = '/img/' + pictureName
    img.width = 300
    img.height = 200
    p.append(img)
    return img
}