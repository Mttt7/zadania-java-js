/** @type {import('tailwindcss').Config} */

module.exports = {
  content: [
    './src/**/*.{html,ts}',
  ],
  theme: {
    extend: {
      colors:{
        "table-bg": "var(--table-bg)",
        "text-table": "var(--text-table)",
      }
    },
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
          "--table-bg": "#ffffff", 
        },
        mydarktheme: { 
          ...require("daisyui/src/theming/themes")["dark"],
          "--table-bg": "#2a323c", 
          "--text-table": "#ffffff",
        },
      },
    ],
    
  },
  plugins: [require('daisyui')],
}


