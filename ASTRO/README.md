# Crear proyecto de Astro
1. Comando para crear el pryecto: ``npm create astro@latest``
    - Seguir las indicaciones del asistente
2. Dentro del proyecto para arrancarlo: ``npm run dev``
3. Añadir tailwind: ``npx astro add tailwind``


# VIDEOS YT
https://youtu.be/Qe7MytTo7Vg 
https://youtu.be/RB5tR_nqUEw
BASE DE DATOS: https://youtu.be/Lr5TRr4iQ7Y


# Horario segun usuario
```
Para que Astro lo pille se pone:(dentro de la etiqueta)  is:line
<script is:line>
    const TIMESTAMP = 1723543200
    const d = new Date(TIMESTAMP)
    const date = d.toLocaleTimetring{"es",
        hour: "2-digit",
        minute: "2-digit"
    }


    const selfScript = document.currentScript
    console.log(selfScript)
    selfScript.parentNode.innerHTML = '{$date}'
</script>
```
# Cuenta atras
```
(Esto va en la parte de arriba de Astro)
const TIMESTAMP = (lo de arriba (la misma variable))
<div date-date={TIMESTAMP}>
<div>
<span date-day>00</span>
<span>DIAS</span>
</div>
</div>

(dentro del html)
<script>
const SECOND= 100
const MINUTE = SECOND * 60
const DAY = HOUR * 60
function init(){
    const $countdown = document.querySelector('[date-date]')
    if (!$countdown) return
    
     //Hacer lo mismo con los minutos, segundos y horas
    const $days = $countdown.querySelector('[date-days]')
    
    const timestamp = $countdown.getAttribute('date-date')
    if (!$timestamp) return

    const date = new Date (+timestamp).getTime()
    
    const formatTime = (time: numbre){
        return Math.floor(time).toString().padStart(2, "0")
    }

    function updateCountdown(){
        const now = Date.now()
        const diff = date - now
        if($days instanceof HTMLElemnt){
        $days.innerText = formatText(diff / DAY)

        }
        
        if($HOUR instanceof HTMLElemnt){
        $days.innerText = formatText((diff % HOUR) / MINUTE) 

        }
        if($HOUR instanceof HTMLElemnt){
        $days.innerText = formatText((diff % MINUTE) / SECOND) 
        }
    }
    setInterval(updateCountdown, SECOND)
}

init()
</script>
```


> [!IMPORTANTE]
> https://www.epochconverter.com/
>
> https://youtu.be/BVnhDlbhPvs?list=PLUofhDIg_38rXS6QJDOQky5sYU-hQKwRv&t=5036 (Cuenta atras, tambien esta lo del user)