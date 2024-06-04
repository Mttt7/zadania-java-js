/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/**/*.{html,ts}',
  ],
  theme: {
    extend: {},
  },

  daisyui: {
    themes: [
      {
        mytheme: {
        
"primary": "#60a5fa",
        
"secondary": "#fb7185",
        
"accent": "#86efac",
        
"neutral": "#111827",
        
"base-100": "#f3f4f6",
        
"info": "#60a5fa",
        
"success": "#a3e635",
        
"warning": "#ff9e00",
        
"error": "#f43f5e",
        },
      },
      "forest"
    ],
    darkTheme:false,
  },
  plugins: [require('daisyui')],
}

